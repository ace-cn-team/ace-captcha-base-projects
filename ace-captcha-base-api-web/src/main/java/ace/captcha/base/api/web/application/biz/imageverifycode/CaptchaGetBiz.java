package ace.captcha.base.api.web.application.biz.imageverifycode;

import ace.captcha.base.define.enums.CaptchaTypeEnum;
import ace.captcha.base.define.model.request.GetRequest;
import ace.captcha.base.api.web.application.biz.imageverifycode.util.CaptchaUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 17:32
 * @description
 */
@Component
@Slf4j
public class CaptchaGetBiz {

    @Autowired
    private RedissonClient redissonClient;

    private final static char[] ALPHA_NUMERIC_ALL_CHAR = "abcde2345678gfynmnpwx".toCharArray();


    public void get(GetRequest request) {
        //生成随机数
        String imageVerifyCode = this.newImageVerifyCode(request.getTypeEnum(), request.getCount());

        DefaultKaptcha captchaProducer = this.buildKaptcha(request);

        BufferedImage bufferedImage = captchaProducer.createImage(imageVerifyCode);

        //将随机数存在session中
        String cacheKey = CaptchaUtils.getCacheKey(request.getAppBiz().getAppId(), request.getAppBiz().getBizId(), request.getAppBiz().getBizType());

        RBucket<String> cacheRBucket = redissonClient.getBucket(cacheKey);

        cacheRBucket.set(imageVerifyCode, 5, TimeUnit.MINUTES);


        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //设置响应头通知浏览器以图片的形式打开
        response.setContentType("image/jpeg");
        //设置响应头控制浏览器不要缓存
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        try {
            //将图片写给浏览器
            ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception ex) {
            log.error("生成图形验证码失败", ex);
            throw new RuntimeException(ex);
        }
    }

    private DefaultKaptcha buildKaptcha(GetRequest request) {
        Properties captchaProperties = new Properties();
        captchaProperties.setProperty(Constants.KAPTCHA_BORDER, "no");
        captchaProperties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "255,255,255");
        captchaProperties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, request.getImageWidth() + "");
        captchaProperties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, request.getImageHeight() + "");
//            properties.setProperty("kaptcha.background.clear.from", "245,245,245");
//            properties.setProperty("kaptcha.background.clear.to", "245,245,245");
//            properties.setProperty("kaptcha.noise.color", "195,35,97");
        captchaProperties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, request.getCount() + "");
        captchaProperties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, request.getFontSize() + "");
        captchaProperties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "0,0,0");
        // captchaProperties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
        Config config = new Config(captchaProperties);
        DefaultKaptcha captchaProducer = new DefaultKaptcha();
        captchaProducer.setConfig(config);
        return captchaProducer;
    }

    private String newImageVerifyCode(CaptchaTypeEnum captchaTypeEnum, int verifyCodeCount) {
        if (captchaTypeEnum.equals(CaptchaTypeEnum.NUMBER_AND_CHARACTER)) {
            return RandomStringUtils.random(verifyCodeCount, 0, ALPHA_NUMERIC_ALL_CHAR.length, true, true, ALPHA_NUMERIC_ALL_CHAR);
        } else if (CaptchaTypeEnum.CHARACTER.equals(captchaTypeEnum)) {
            return RandomStringUtils.randomAlphabetic(verifyCodeCount);
        } else {
            return RandomStringUtils.randomNumeric(verifyCodeCount);
        }
    }


}
