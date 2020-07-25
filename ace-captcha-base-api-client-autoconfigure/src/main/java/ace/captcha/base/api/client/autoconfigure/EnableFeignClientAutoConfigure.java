package ace.captcha.base.api.client.autoconfigure;

import ace.captcha.base.define.constant.CaptchaConstants;
import ace.captcha.base.api.web.controller.CaptchaBaseController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/5 1:20
 * @description
 */
@ConditionalOnProperty(
        name = CaptchaConstants.BASE_CONFIG_KEY_API_CLIENT_ENABLE,
        havingValue = "true",
        matchIfMissing = true
)
@ConditionalOnMissingBean({CaptchaBaseController.class})
@ConditionalOnBean(annotation = {EnableFeignClients.class})
@EnableFeignClients(basePackages = {CaptchaConstants.BASE_FEIGN_CLIENT_SERVICE_PACKAGE})
@Configuration
public class EnableFeignClientAutoConfigure {

}
