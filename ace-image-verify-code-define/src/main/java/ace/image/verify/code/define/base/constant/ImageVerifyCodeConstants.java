package ace.image.verify.code.define.base.constant;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 16:21
 * @description
 */
public interface ImageVerifyCodeConstants {
    /**
     * base api layer openfeign微服务配置名称
     */
    String BASE_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-image-verify-code-base-api.name:ace-image-verify-code-base-api-web}";
    /**
     * 是否启用base api layer openfeign微服务自动配置
     */
    String BASE_CONFIG_KEY_API_CLIENT_ENABLE = "ace.ms.service.api.ace-image-verify-code-base-api.enable";
    /**
     * base api layer 包路径
     */
    String BASE_FEIGN_CLIENT_SERVICE_PACKAGE = "ace.image.verify.code.base.api.service";



    /**
     * logic api layer openfeign微服务配置名称
     */
    String LOGIC_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-image-verify-code-logic-api.name:ace-image-verify-code-logic-api-web}";
    /**
     * 是否启用 logic api layer openfeign微服务自动配置
     */
    String LOGIC_CONFIG_KEY_API_CLIENT_ENABLE = "ace.ms.service.api.ace-image-verify-code-logic-api.enable";
    /**
     * logic api layer 包路径
     */
    String LOGIC_FEIGN_CLIENT_SERVICE_PACKAGE = "ace.image.verify.code.logic.api.service";
}
