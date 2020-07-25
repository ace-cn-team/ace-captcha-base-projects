package ace.captcha.base.define.model.request;

import ace.common.base.define.model.request.CommonAppRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/3 11:23
 * @description
 */
@Data
@Accessors(chain = true)
public class CheckRequest extends CommonAppRequest {

    @ApiModelProperty(value = "图形验证码", required = true)
    @NotBlank(message = "请输入验证码")
    @Length(min = 1, max = 36, message = "请输入正确的验证码")
    private String verifyCode;
}
