package ace.image.verify.code.base.api.web.application.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.image.verify.code.base.api.controller.ImageVerifyCodeBaseController;
import ace.image.verify.code.base.api.web.application.biz.imageverifycode.ImageVerifyCodeCheckBiz;
import ace.image.verify.code.base.api.web.application.biz.imageverifycode.ImageVerifyCodeGetBiz;
import ace.image.verify.code.define.base.model.request.CheckRequest;
import ace.image.verify.code.define.base.model.request.GetImageVerifyCodeRequest;

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
public class ImageVerifyCodeBaseControllerImpl implements ImageVerifyCodeBaseController {
    @Autowired
    private ImageVerifyCodeGetBiz getBiz;
    @Autowired
    private ImageVerifyCodeCheckBiz imageVerifyCodeCheckBiz;

    @Override
    public Response get(@Valid GetImageVerifyCodeRequest request) {
        getBiz.execute(request);
        return null;
    }

    @Override
    public GenericResponseExt<Boolean> check(@Valid CheckRequest request) {
        imageVerifyCodeCheckBiz.execute(request);
        return GenericResponseExtUtils.buildSuccessWithData(true);
    }
}
