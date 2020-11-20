package cn.silince.springcloud.service.impl;

import cn.silince.springcloud.dao.PaymentDao;
import cn.silince.springcloud.entities.Payment;
import cn.silince.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: cloud2020
 * @description:
 * @author: Silince
 * @create: 2020-11-20 20:56
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
