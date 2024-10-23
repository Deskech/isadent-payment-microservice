package com.microservices.Abono.Infrastructure.Factories.Interfaces;

import com.microservices.Abono.Infrastructure.Entities.CommandLine.WritePaymentEntity;

/**
 * This interface creates WritePaymentEntity objects from different types of payment data.
 *
 * @param <T> the type of payment input used to create a WritePaymentEntity
 */
public interface FactoryWritePaymentEntity<T> {
    /**
     * Creates a WritePaymentEntity using the provided payment data.
     *
     * @param payment the payment data to convert into a WritePaymentEntity
     * @return a new WritePaymentEntity object
     */
    WritePaymentEntity create(T payment);
}
