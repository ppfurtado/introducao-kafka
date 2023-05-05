package com.ppfurtado.jsonconsumer.listener;

import com.ppfurtado.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;


@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraude(@Payload Payment payment){
        log.info("Recebi o pagamento {}", payment.toString());
        log.info("Validando Fraude...");
        sleep(2000);


        log.info("Compra aprovada...");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        sleep(3000);
        log.info("Gerando PDF do produto do id {}...", payment.getId());
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment){
        log.info("Enviando email da compra do cardNumer {}", payment.getCardNumber());
        log.info("Enviando email de confirmação...");
    }

}
