package com.microservices.Abono.Domain.Services;

/**
 * This domain service saves the payments in different cases
 */
public interface SavePayment<T> {
    /**
     *
     * @param lastPayment the las payment the patient did
     */
    void savePayment(T lastPayment);

    /**
     *
     * @param firstPayment references the first payment comming from the Quotation microservice
     */
    void saveFirstPayment(T firstPayment);
}
