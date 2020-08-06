package com.oklimenko.payment.controller;

import com.oklimenko.payment.dto.NewPaymentDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentSystemController {
    /*@KafkaListener(
            topics = "topicName",
            containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(NewPaymentDto newPaymentDto) {
        System.out.println(newPaymentDto);
    }*/
}
