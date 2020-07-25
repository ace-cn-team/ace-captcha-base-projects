package ace.captcha.base.api;

import ace.captcha.base.define.constant.CaptchaConstants;
import ace.captcha.base.define.model.request.CheckRequest;
import ace.captcha.base.define.model.request.GetRequest;
import ace.captcha.base.define.model.request.RemoveRequest;
import ace.fw.model.response.GenericResponseExt;
import feign.Response;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description 图形验证码
 */
@FeignClient(
        name = CaptchaConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "CaptchaBaseApi",
        path = "/" + CaptchaBaseApi.MODULE_RESTFUL_NAME
)
@Validated
public interface CaptchaBaseApi {
    String MODULE_RESTFUL_NAME = "captcha-base";

    @ApiOperation(value = "获取图形验证码")
    @RequestMapping(path = "/get", method = RequestMethod.POST)
    Response get(@Valid @RequestBody GetRequest request);

    @ApiOperation(value = "验证图形验证码")
    @RequestMapping(path = "/check", method = RequestMethod.POST)
    GenericResponseExt<Boolean> check(@Valid @RequestBody CheckRequest request);
    @ApiOperation(value = "删除图形验证码")
    @RequestMapping(path = "/remove", method = RequestMethod.POST)
    GenericResponseExt<Boolean> remove(@Valid @RequestBody RemoveRequest request);
}
