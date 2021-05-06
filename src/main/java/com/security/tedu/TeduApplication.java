package com.security.tedu;

import com.security.tedu.utils.VerifyServlet;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeduApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeduApplication.class, args);
    }

    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }

//    @Bean
//    public RedissonClient redisson(){
//        Config config = new Config();
//        config.useSingleServer().setAddress("127.0.0.1:7001");
//        return Redisson.create(config);
//
//    }

}
