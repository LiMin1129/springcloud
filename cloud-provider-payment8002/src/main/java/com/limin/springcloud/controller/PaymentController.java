package com.limin.springcloud.controller;

import com.limin.springcloud.entities.CommonResult;
import com.limin.springcloud.entities.Payment;
import com.limin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author LiMin
 * @date 2021/12/6-21:31
 * @DESCRIPTION
 */

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果:" + result);
        if (result > 0){
            return new CommonResult(200,"数据库插入成功,serverPort: " + serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******插入结果" +payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverPort: " + serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录",null);

        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/sleep")
    public String paymentTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
