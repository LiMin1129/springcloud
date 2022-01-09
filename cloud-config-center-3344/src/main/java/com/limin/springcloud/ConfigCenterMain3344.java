package com.limin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * @author LiMin
 * @date 2022/1/7-21:45
 * @DESCRIPTION
 */
@SpringBootApplication
@EnableConfigServer
//@EnableEurekaClient
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }

}
