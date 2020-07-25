package ace.account.base.api.web.biz;

import ace.captcha.base.api.CaptchaBaseApi;
import ace.captcha.base.api.client.application.ClientJUnitBaseApplication;
import ace.captcha.base.define.model.request.CheckRequest;
import ace.captcha.base.define.model.request.GetRequest;
import ace.captcha.base.define.model.request.RemoveRequest;
import ace.common.base.define.model.bo.AppBiz;
import ace.fw.json.JsonUtils;
import ace.fw.util.AceLocalDateTimeUtils;
import com.fasterxml.uuid.Generators;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/6/28 14:32
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientJUnitBaseApplication.class)
public class CheckAllBizTest {

    private final static String BIZ_ID = "15099975787";
    private final static String SYSTEM_VERIFY_CODE = "888888";
    @Autowired
    private CaptchaBaseApi captchaBaseApi;


    @Test
    public void testAllBiz() {
        this.testGet();
        log.info("get success");
        this.testCheck();
        log.info("check success");
        this.testRemove();
        log.info("remove success");
    }

    private void testRemove() {
        RemoveRequest removeRequest = new RemoveRequest();
        removeRequest.setAppBiz(
                AppBiz.builder()
                        .appId(Generators.timeBasedGenerator().generate().toString())
                        .bizType(Generators.timeBasedGenerator().generate().toString())
                        .bizId(Generators.timeBasedGenerator().generate().toString())
                        .build());
        captchaBaseApi.remove(removeRequest).check();
    }

    private void testCheck() {
        CheckRequest checkRequest = new CheckRequest();
        checkRequest.setVerifyCode(SYSTEM_VERIFY_CODE)
                .setAppBiz(AppBiz.builder()
                        .appId(Generators.timeBasedGenerator().generate().toString())
                        .bizType(Generators.timeBasedGenerator().generate().toString())
                        .bizId(Generators.timeBasedGenerator().generate().toString())
                        .build());
        captchaBaseApi.check(checkRequest).check();
    }

    private void testGet() {
        GetRequest getRequest = new GetRequest();
        getRequest.setAppBiz(
                AppBiz.builder()
                        .appId(Generators.timeBasedGenerator().generate().toString())
                        .bizId(Generators.timeBasedGenerator().generate().toString())
                        .bizType(Generators.timeBasedGenerator().generate().toString())
                        .build()
        );
        Response response = captchaBaseApi.get(getRequest);
        if (response.status() != 200) {
            log.error("获取图形验证码图片失败,http status{}", response.status());
            throw new RuntimeException("获取图形验证码图片失败");
        }
    }


}
