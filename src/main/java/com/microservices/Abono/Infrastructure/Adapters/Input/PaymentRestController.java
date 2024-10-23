package com.microservices.Abono.Infrastructure.Adapters.Input;

import com.microservices.Abono.Application.Dto.NewPayment;
import com.microservices.Abono.Application.Dto.Patient;
import com.microservices.Abono.Application.Services.SavePayments;
import com.microservices.Abono.Application.Services.ShowPayments;
import com.microservices.Abono.Domain.Model.Query.PaymentView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing payment transactions.
 * This controller handles requests related to saving new payments and retrieving payment history.
 */
@RestController
public class PaymentRestController {

    private final SavePayments savePayments;
    private final ShowPayments showPayments;

    public PaymentRestController(SavePayments savePayments, ShowPayments showPayments) {
        this.savePayments = savePayments;
        this.showPayments = showPayments;
    }

    /**
     * Saves a new payment.
     *
     * @param newPayment the new payment object to be saved
     */
    @CrossOrigin
    @PostMapping("/payments/newPayment")
    public void savePayment(@RequestBody NewPayment newPayment) {
        savePayments.setNewPayment(newPayment);
    }

    /**
     * Retrieves the payment history for a specified patient.
     *
     * @param patient the patient object containing the patient's name
     * @return a list of PaymentView objects representing the payment history
     */
    @CrossOrigin
    @PostMapping("/payments/history")
    public List<PaymentView> getPayments(@RequestBody Patient patient) {
        return showPayments.getPaymentsByPatientName(patient.getPatientName());
    }
}
