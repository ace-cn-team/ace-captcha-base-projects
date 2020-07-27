package ace.captcha.base.define.model.request;

import ace.captcha.base.define.constraint.CaptchaVerifyCodeIdConstraint;
import ace.captcha.base.define.model.bo.CaptchaVerifyCodeId;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 16:56
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveRequest {
    @Valid
    @CaptchaVerifyCodeIdConstraint
    @ApiModelProperty(value = CaptchaVerifyCodeIdConstraint.FIELD_NAME, required = true)
    private CaptchaVerifyCodeId verifyCodeId;
}