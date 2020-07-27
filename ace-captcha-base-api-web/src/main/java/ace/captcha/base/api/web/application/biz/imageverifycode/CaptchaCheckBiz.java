package ace.captcha.base.api.web.application.biz.imageverifycode;

import ace.captcha.base.api.web.application.biz.imageverifycode.util.CaptchaUtils;
import ace.captcha.base.api.web.application.property.CaptchaProperties;
import ace.captcha.base.define.enums.CaptchaBusinessErrorEnum;
import ace.captcha.base.define.model.request.CheckRequest;
import ace.fw.util.BusinessErrorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 17:32
 * @description
 */
@Component
@Slf4j
public class CaptchaCheckBiz {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private CaptchaProperties captchaProperties;

    public void check(CheckRequest request) {
        // 是否启用并且是系统验证码
        if (this.isSystemVerifyCodePass(request)) {
            return;
        }
        String cacheKey = CaptchaUtils.getCacheKey(request.getVerifyCodeId().getAppId(), request.getVerifyCodeId().getBizId(), request.getVerifyCodeId().getBizType());
        RBucket<String> cacheRBucket = redissonClient.getBucket(cacheKey);
        String cacheValue = cacheRBucket.get();
        if (StringUtils.isBlank(cacheValue)) {
            BusinessErrorUtils.throwNew(CaptchaBusinessErrorEnum.EXPIRE);
        }
        if (cacheValue.equalsIgnoreCase(request.getVerifyCode()) == false) {
            BusinessErrorUtils.throwNew(CaptchaBusinessErrorEnum.INCORRECT);
        }
    }

    /**
     * 是否启用并且是系统验证码
     *
     * @return
     */
    private boolean isSystemVerifyCodePass(CheckRequest request) {
        boolean isSystemVerifyCodePass = captchaProperties != null &&
                captchaProperties.getVerifyCode() != null &&
                captchaProperties.getVerifyCode().getEnable() != null &&
                Boolean.TRUE.equals(captchaProperties.getVerifyCode().getEnable()) &&
                StringUtils.equalsIgnoreCase(captchaProperties.getVerifyCode().getValue(), request.getVerifyCode());
        return isSystemVerifyCodePass;
    }
}
