package ace.captcha.base.define.constant;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 16:21
 * @description
 */
public interface CaptchaConstants {
    /**
     * base api layer openfeign微服务配置名称
     */
    String BASE_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-captcha-base-api.name:ace-captcha-base-api-web}";
    /**
     * 是否启用base api layer openfeign微服务自动配置
     */
    String BASE_CONFIG_KEY_API_CLIENT_ENABLE = "ace.ms.service.api.ace-captcha-base-api.enable";
    /**
     * base api layer 包路径
     */
    String BASE_FEIGN_CLIENT_SERVICE_PACKAGE = "ace.captcha.base.api";
}
