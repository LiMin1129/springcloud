package com.limin.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author LiMin
 * @date 2021/12/28-14:49
 * @DESCRIPTION
 */
@Service
public class PaymentService {
    /**
     * 正常访问 一切OK
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id){
        return "线程池：  " + Thread.currentThread().getName() + " paymentInfo_Ok,id: " + id + "\t" + "😊O(∩_∩)O";
    }

    /**
     * @HystrixCommand 服务降级方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_fallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 2;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int age = 10 / 0;
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "Failed" + "时间 ：" + timeNumber;
    }

    public String paymentInfo_fallbackMethod(Integer id){
        return "线程池： " + Thread.currentThread().getName() + " 8001系统运行异常 " + "Failed /(ㄒoㄒ)/~~" ;
    }


    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
