package ace.captcha.base.define.model.bo;

import ace.common.base.define.model.constraint.AppIdConstraint;
import ace.common.base.define.model.constraint.BizIdConstraint;
import ace.common.base.define.model.constraint.BizTypeConstraint;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/27 10:48
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CaptchaVerifyCodeId {
    /**
     * 应用ID
     */
    @AppIdConstraint
    @ApiModelProperty(value = AppIdConstraint.FIELD_NAME, required = true)
    private String appId;
    /**
     * 业务类型
     */
    @BizTypeConstraint
    @ApiModelProperty(value = BizTypeConstraint.FIELD_NAME, required = true)
    private String bizType;
    /**
     * 手机号码
     */
    @BizIdConstraint
    @ApiModelProperty(value = BizIdConstraint.FIELD_NAME, required = true)
    private String bizId;
}
