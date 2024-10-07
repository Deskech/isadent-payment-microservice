package com.microservices.Abono.Domain.Events;
/**
 * Interface for reporting the last payment to the bill microservice.
 * This interface defines a method to send the last payment information.
 */
public interface LastPayment<T> {
    /**
     * Reports the last payment to the bill microservice.
     *
     * @param lastPayment the payment object representing the last payment made
     */
    void reportLastPayment(T lastPayment);
}
