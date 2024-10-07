package com.microservices.Abono.Application.Services;

import com.microservices.Abono.Domain.Model.Query.PaymentView;
import com.microservices.Abono.Domain.Services.PaymentViewService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service class responsible for showing the payment history of a patient.
 * This class retrieves the payment history by interacting with the PaymentViewService.
 */

@Service
public class ShowPayments {
    private final PaymentViewService paymentViewService;

    public ShowPayments(PaymentViewService paymentViewService) {
        this.paymentViewService = paymentViewService;
    }
    /**
     * Retrieves the payment history for a given patient by their name.
     *
     * @param patientName The name of the patient whose payment history is requested.
     * @return A list of PaymentView objects representing the patient's payment history.
     */
    public List<PaymentView>porNombrePaciente(String patientName) {
        return paymentViewService.viewPaymentHistory(patientName);
    }
}
