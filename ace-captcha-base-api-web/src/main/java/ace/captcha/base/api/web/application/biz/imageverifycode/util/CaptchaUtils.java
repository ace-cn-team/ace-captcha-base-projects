package ace.captcha.base.api.web.application.biz.imageverifycode.util;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/3 11:26
 * @description
 */
public final class CaptchaUtils {
    /**
     * 获取缓存的key
     *
     * @param appId
     * @param bizId
     * @param bizType
     * @return
     */
    public static String getCacheKey(String appId, String bizId, String bizType) {
        return String.format("ace:captcha:%s:%s:%s", appId, bizType, bizId);
    }
}
