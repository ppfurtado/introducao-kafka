package com.ppfurtado.paymentservice.service;

import com.ppfurtado.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
