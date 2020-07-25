package ace.captcha.base.api.web.application.property;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/25 14:29
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaVerifyCodeProperties {
    /**
     * 是否启用
     */
    private Boolean enable;
    /**
     * 系统验证码
     */
    private String value;
}
