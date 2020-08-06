package com.oklimenko.payment.service;

import com.oklimenko.payment.dto.NewPaymentSystemDto;
import com.oklimenko.payment.dto.PaymentStatus;
import com.oklimenko.payment.dto.PaymentSystemEvent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@RequiredArgsConstructor
@Component
public class KafkaPaymentConsumer {

    private final Random random = new Random();

    private final KafkaTemplate<Long, PaymentSystemEvent> producerKafkaTemplate;

    @Value("${kafka.producer.topic}")
    private String kafkaProducerTopic;

    @SneakyThrows
    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}",
            containerFactory = "newPaymentKafkaListenerContainerFactory")
    public void listen(NewPaymentSystemDto message) {
        System.out.println("Received Messasge in group foo: " + message);

        PaymentStatus paymentStatus = executePaymentSystemStub(message);
        System.out.println("PAYMENT EXECUTED in external system, status: " + paymentStatus);
        PaymentSystemEvent paymentSystemEvent = new PaymentSystemEvent();
        paymentSystemEvent.setPaymentId(message.getPaymentId());
        paymentSystemEvent.setStatus(paymentStatus);

        sendToPaymentGateway( paymentSystemEvent );
    }

    private PaymentStatus executePaymentSystemStub(NewPaymentSystemDto message) throws InterruptedException {
        // this timeout is dirty emulation of external payment system processing
        Thread.sleep(500 + random.nextInt(1000));
        if (message.getServiceId() == 42L) {
            throw new RuntimeException("Payment stuck");
        }
        return message.getServiceId() == 10L ? PaymentStatus.REJECTED : PaymentStatus.APPROVED;
    }

    private void sendToPaymentGateway(PaymentSystemEvent dto) {
        producerKafkaTemplate.send(kafkaProducerTopic, dto);
    }
}
