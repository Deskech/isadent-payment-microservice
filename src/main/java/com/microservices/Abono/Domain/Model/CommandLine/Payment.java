package com.microservices.Abono.Domain.Model.CommandLine;

import lombok.Getter;


import java.time.LocalDate;

/**
 *Represents a payment transaction for a patient.
 *This class encapsulates payment values, patient details, and the transaction date.
 */
@Getter
public class Payment {
    private final PaymentValues paymentValues;
    private final String patientName;
    private final LocalDate date;
    public Payment(PaymentValues paymentValues, String patientName, LocalDate date){
        this.paymentValues = paymentValues;
        this.patientName = patientName;
        this.date = date;
    }
    /**
     * Creates a new Payment instance.
     *
     * @param paymentValues the payment values for the transaction
     * @param patientName   the name of the patient making the payment
     * @param date          the date of the payment
     * @return a new Payment instance
     * @throws IllegalArgumentException if any required fields are null
     */
    public static Payment crearAbono(PaymentValues paymentValues, String patientName, LocalDate date){
        if (paymentValues.getPaymentValue() == null || paymentValues.getPaymentCurrency() == null || patientName == null){
            throw new IllegalArgumentException("One payment and one patient name must be specified");
        }
        return new Payment(paymentValues, patientName, date);
    }
}
