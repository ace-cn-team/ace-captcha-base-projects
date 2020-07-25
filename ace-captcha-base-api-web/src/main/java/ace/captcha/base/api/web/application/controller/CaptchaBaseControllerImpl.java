package ace.captcha.base.api.web.application.controller;

import ace.captcha.base.api.web.application.biz.imageverifycode.CaptchaRemoveBiz;
import ace.captcha.base.define.model.request.CheckRequest;
import ace.captcha.base.define.model.request.GetRequest;
import ace.captcha.base.define.model.request.RemoveRequest;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.captcha.base.api.web.controller.CaptchaBaseController;
import ace.captcha.base.api.web.application.biz.imageverifycode.CaptchaCheckBiz;
import ace.captcha.base.api.web.application.biz.imageverifycode.CaptchaGetBiz;

import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */
@RestController
@Validated
@Slf4j
public class CaptchaBaseControllerImpl implements CaptchaBaseController {
    @Autowired
    private CaptchaGetBiz captchaGetBiz;
    @Autowired
    private CaptchaCheckBiz captchaCheckBiz;
    @Autowired
    private CaptchaRemoveBiz captchaRemoveBiz;

    @Override
    public Response get(@Valid GetRequest request) {
        captchaGetBiz.get(request);
        return null;
    }

    @Override
    public GenericResponseExt<Boolean> check(@Valid CheckRequest request) {
        captchaCheckBiz.check(request);
        return GenericResponseExtUtils.buildSuccessWithData(true);
    }

    @Override
    public GenericResponseExt<Boolean> remove(@Valid RemoveRequest request) {
        captchaRemoveBiz.remove(request);
        return GenericResponseExtUtils.buildSuccessWithData(true);
    }
}
