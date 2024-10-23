package com.microservices.Abono.Domain.Model.CommandLine;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Represents the payment values including currency and amount.
 */
@EqualsAndHashCode
@Getter
public final class PaymentValues {

    private final String paymentCurrency;
    private final Double paymentValue;

    public PaymentValues(String paymentCurrency, Double paymentValue) {
        this.paymentCurrency = paymentCurrency;
        this.paymentValue = paymentValue;
    }

}
