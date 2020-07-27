package ace.captcha.base.api.web.application.biz.imageverifycode;

import ace.captcha.base.api.web.application.biz.imageverifycode.util.CaptchaUtils;
import ace.captcha.base.define.enums.CaptchaTypeEnum;
import ace.captcha.base.define.model.request.GetRequest;
import ace.captcha.base.define.model.request.RemoveRequest;
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
public class CaptchaRemoveBiz {

    @Autowired
    private RedissonClient redissonClient;

    public void remove(RemoveRequest request) {
        String cacheKey = CaptchaUtils.getCacheKey(request.getVerifyCodeId().getAppId(), request.getVerifyCodeId().getBizId(), request.getVerifyCodeId().getBizType());
        RBucket<String> cacheRBucket = redissonClient.getBucket(cacheKey);
        cacheRBucket.deleteAsync();
    }
}
