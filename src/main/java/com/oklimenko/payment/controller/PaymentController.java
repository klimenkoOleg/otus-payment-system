package com.oklimenko.payment.controller;

import com.oklimenko.payment.dto.NewPaymentDto;
import com.oklimenko.payment.exception.PaymentGateException;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class PaymentController {

    private final Random random = new Random();

    @PostMapping("/sendPayment")
    @SneakyThrows
    public void transferPayment(@RequestBody NewPaymentDto payment) {
        Thread.sleep(10+random.nextInt(90));
        long serviceId = payment.getServiceId();
        if (serviceId == 10L) {
            throw new PaymentGateException("Payment gate is not availible todate for servideId=" + serviceId);
        }
        // no-op - implementation is omitted to due real integration need with payment system.
    }
}
