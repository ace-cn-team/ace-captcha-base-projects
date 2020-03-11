package ace.image.verify.code.base.api.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/3 15:21
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ImageVerifyCodeBaseApiWebApplication {
    public static void main(String[] args) {

        try {
            SpringApplication.run(ImageVerifyCodeBaseApiWebApplication.class, args);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
