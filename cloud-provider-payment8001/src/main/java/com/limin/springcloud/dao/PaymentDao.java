package com.limin.springcloud.dao;

import com.limin.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiMin
 * @date 2021/12/6-16:38
 * @DESCRIPTION
 */
@Mapper
public interface PaymentDao {
    /**
     * 增删改查
     */
     public int create(Payment payment);

     public Payment getPaymentById(@Param("id") Long id);

}
