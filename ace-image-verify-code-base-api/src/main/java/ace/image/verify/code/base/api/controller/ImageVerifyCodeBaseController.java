package ace.image.verify.code.base.api.controller;

import ace.image.verify.code.base.api.service.ImageVerifyCodeBaseService;
import ace.image.verify.code.define.base.model.request.GetImageVerifyCodeRequest;

import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */

@RestController
@RequestMapping(path = "/" + ImageVerifyCodeBaseService.MODULE_RESTFUL_NAME)
@Validated
public interface ImageVerifyCodeBaseController extends ImageVerifyCodeBaseService {

}
