package com.microservices.Abono.Application.Dto;

import lombok.Getter;
/**
 * Represents a new payment made by a patient.
 * This class holds the patient's name and the payment value.
 */
@Getter
public class NewPayment {
    private final String patientName;
    private final Double paymentValue;
    public NewPayment(String patientName, Double paymentValue){
        this.patientName= patientName;
        this.paymentValue = paymentValue;
    }

}
