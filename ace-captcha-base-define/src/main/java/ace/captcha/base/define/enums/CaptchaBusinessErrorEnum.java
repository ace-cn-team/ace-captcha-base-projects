package ace.captcha.base.define.enums;

import ace.fw.enums.BaseEnum;
import lombok.Getter;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 17:24
 * @description {@link ace.common.base.define.constant.SystemCodeConstants}
 * 图形验证码模块
 * Integer[] CAPTCHA = new Integer[]{900000, 919999};
 */
public enum CaptchaBusinessErrorEnum implements BaseEnum<String> {
    INCORRECT("900000", "请输入正确的验证码"),
    EXPIRE("900001", "验证码已过期,请刷新"),

    ;
    @Getter
    private String code;
    @Getter
    private String desc;

    CaptchaBusinessErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
