package com.oklimenko.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class ProcessedPaymentDto {
    private long paymentId;
    private LocalDateTime dateCreated;
    private LocalDateTime dateCompleted;
}
