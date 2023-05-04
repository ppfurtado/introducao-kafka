package com.ppfurtado.strconsumer.listeners;

import com.ppfurtado.strconsumer.custom.StrConsumerCustonListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumerListener {

    @StrConsumerCustonListener(groupId = "0")
    public void create(String message){
        log.info("CREATE ::: Receive message {}", message);
    }

    @StrConsumerCustonListener(groupId = "1")
    public void log(String message){
        log.info("LOG ::: Receive message {}", message);
    }

    @StrConsumerCustonListener(groupId = "2", containerFactory = "validMessageContainFactory")
    public void history(String message){
        log.info("HISTORY ::: Receive message {}", message);
    }
}
