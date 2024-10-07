package com.microservices.Abono.Domain.Repositories.CommandLine;
/**
 * Repository interface for managing payment transactions.
 * This interface defines methods for registering payments in the database.
 *
 * @param <T> the type of payment to be registered
 */
public interface PaymentRepository<T> {
    /**
     * Registers a new payment for a user who already has previous payments.
     * This method stores the new payment in the database.
     *
     * @param payment the payment object to be registered
     */
    void registerPayment(T payment);
    /**
     * Listens for quotation events and registers the user's payment or non-payment.
     * This method stores the payment status when the quotation is made.
     *
     * @param payment the payment object representing the user's response to the quotation
     */

    void registerFirstPayment(T payment);
}
