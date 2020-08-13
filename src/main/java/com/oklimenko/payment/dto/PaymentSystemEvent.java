package com.oklimenko.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class PaymentSystemEvent {
    private UUID paymentId;
    private PaymentStatus status;
}
