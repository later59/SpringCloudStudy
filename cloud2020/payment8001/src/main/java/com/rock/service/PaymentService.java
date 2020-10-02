package com.rock.service;


import com.rock.payment.entities.Payment;

public interface PaymentService {

    int add(Payment payment);

    Payment getPaymentById(Long id);
}
