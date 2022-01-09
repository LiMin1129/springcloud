package com.limin.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author LiMin
 * @date 2021/12/23-15:18
 * @DESCRIPTION
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
//        UUID 唯一机器识别码
        return "springCloud with consul" + serverPort +"\t" + UUID.randomUUID().toString();
    }
}
