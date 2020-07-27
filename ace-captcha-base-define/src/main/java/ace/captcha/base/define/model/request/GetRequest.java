package ace.captcha.base.define.model.request;

import ace.captcha.base.define.constraint.CaptchaVerifyCodeIdConstraint;
import ace.captcha.base.define.enums.CaptchaTypeEnum;
import ace.captcha.base.define.model.bo.CaptchaVerifyCodeId;

import ace.fw.util.AceEnumUtils;
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
@NoArgsConstructor
@AllArgsConstructor
public class GetRequest {
    private final static Integer DEFAULT_IMAGE_WIDTH = 100;
    private final static Integer DEFAULT_IMAGE_HEIGHT = 50;
    private final static Integer DEFAULT_COUNT = 4;
    private final static Integer DEFAULT_FONT_SIZE = 40;
    private final static Integer DEFAULT_TYPE = 2;


    @ApiModelProperty(value = "图片验证码图片宽度,默认:100", required = true)
    private Integer imageWidth = DEFAULT_IMAGE_WIDTH;
    @ApiModelProperty(value = "图片验证码图片高度，默认50", required = true)
    private Integer imageHeight = DEFAULT_IMAGE_HEIGHT;
    @ApiModelProperty(value = "图片验证码长度,默认值：4", required = true)
    private Integer count = DEFAULT_COUNT;
    @ApiModelProperty(value = "图片验证码字体大小,默认值：40", required = true)
    private Integer fontSize = DEFAULT_FONT_SIZE;
    @ApiModelProperty(value = "图片验证码类型，0-纯数字，1-纯字母，2-数字与字母", required = true)
    private Integer type = DEFAULT_TYPE;
    @Valid
    @CaptchaVerifyCodeIdConstraint
    @ApiModelProperty(value = CaptchaVerifyCodeIdConstraint.FIELD_NAME, required = true)
    private CaptchaVerifyCodeId verifyCodeId;

    @ApiModelProperty(hidden = true)
    public CaptchaTypeEnum getTypeEnum() {
        return AceEnumUtils.getEnum(CaptchaTypeEnum.class, this.type);
    }


}
