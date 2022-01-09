package com.limin.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author LiMin
 * @date 2021/12/29-15:07
 * @DESCRIPTION
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "---PaymentFallbackService fall back back--paymentInfo_Ok,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---PaymentFallbackService fall back back-- paymentInfo_timeout,/(ㄒoㄒ)/~~";
    }
}
