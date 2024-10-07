package com.microservices.Abono.Domain.Factories;

import com.microservices.Abono.Domain.Model.CommandLine.Payment;
/**
 * Factory interface for creating payment objects.
 * This interface defines a method for creating payment instances based on the provided data.
 */
public interface PaymentFactory<T> {
    /**
     * Creates a new Payment instance based on the provided input data.
     *
     * @param newPayment the data used to create the payment
     * @return a new Payment object
     */
    Payment create(T newPayment);
}
