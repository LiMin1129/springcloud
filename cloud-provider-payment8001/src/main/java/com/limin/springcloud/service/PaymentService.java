package com.limin.springcloud.service;

import com.limin.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiMin
 * @date 2021/12/6-21:26
 * @DESCRIPTION
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
