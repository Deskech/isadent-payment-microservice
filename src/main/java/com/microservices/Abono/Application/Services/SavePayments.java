package com.microservices.Abono.Application.Services;

import com.microservices.Abono.Application.Dto.NewPayment;
import com.microservices.Abono.Domain.Services.SavePayment;
import org.springframework.stereotype.Service;
/**
 * Service class responsible for saving payments.
 * This class handles both first-time payments and subsequent payments by interacting with the SavePayment interface.
 */
@Service
public class SavePayments {
    private final SavePayment<NewPayment> savePayment;

    public SavePayments(SavePayment<NewPayment> savePayment){
        this.savePayment = savePayment;
    }
    /**
     * Saves the first payment for a new patient.
     *
     * @param newPayment The details of the first payment to be saved.
     */
    public void firstPayment(NewPayment newPayment){
        savePayment.saveFirstPayment(newPayment);
    }
    /**
     * Saves a subsequent payment for an existing patient.
     *
     * @param newPayment The details of the payment to be saved.
     */
    public void setNewPayment(NewPayment newPayment){
        savePayment.savePayment(newPayment);
    }
}
