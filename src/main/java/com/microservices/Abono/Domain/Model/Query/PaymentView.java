package com.microservices.Abono.Domain.Model.Query;

import lombok.Getter;
/**
 * Represents a view of payment transactions made by a patient over time.
 * This class contains the relevant details for displaying payment information.
 */
@Getter
public class PaymentView {
    private final String paymentCurrency;
    private final String patientName;
    private final String paymentDate;
    /**
     * Constructs a PaymentView object with the specified currency, patient name, and payment date.
     *
     * @param paymentCurrency the money format of the payment amount
     * @param patientName     the name of the patient associated with the payment
     * @param paymentDate     the date of the payment in string format
     */
    public PaymentView(String paymentCurrency, String patientName, String paymentDate){
        this.paymentCurrency= paymentCurrency;
        this.patientName = patientName;
        this.paymentDate = paymentDate;
    }
}
