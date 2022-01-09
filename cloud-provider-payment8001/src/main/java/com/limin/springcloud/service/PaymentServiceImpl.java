package com.limin.springcloud.service;

import com.limin.springcloud.dao.PaymentDao;
import com.limin.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LiMin
 * @date 2021/12/6-21:27
 * @DESCRIPTION
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    public PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
