package com.microservices.Abono.Infrastructure.Factories.Interfaces;

import com.microservices.Abono.Infrastructure.Entities.Query.QueryPaymentEntity;

/**
 * This interface creates QueryPaymentEntity objects from different types of payment data.
 *
 * @param <T> the type of payment input used to create a QueryPaymentEntity
 */
public interface FactoryQueryPaymentEntity<T> {
    /**
     * Creates a QueryPaymentEntity using the provided payment data.
     *
     * @param payment the payment data to convert into a QueryPaymentEntity
     * @return a new QueryPaymentEntity object
     */
    QueryPaymentEntity create(T payment);
}
