package com.oklimenko.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class NewPaymentDto {
    private long clientId;
    private long serviceId;
    private BigDecimal amount;
    private String clientComment;
}
