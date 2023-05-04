package com.ppfurtado.paymentservice.service.impl;

import com.ppfurtado.paymentservice.model.Payment;
import com.ppfurtado.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL Recebi um pagamento {}", payment);
    }
}
