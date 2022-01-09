package com.limin.springcloud.controller;

import com.limin.springcloud.entities.CommonResult;
import com.limin.springcloud.entities.Payment;
import com.limin.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LiMin
 * @date 2021/12/27-15:29
 * @DESCRIPTION
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("openFeign 调用： " + id);
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/sleep")
    public String paymentTimeOut(){
        return paymentFeignService.paymentTimeOut();
    }
}
