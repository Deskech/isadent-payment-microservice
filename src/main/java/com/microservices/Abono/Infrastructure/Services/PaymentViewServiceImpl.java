package com.microservices.Abono.Infrastructure.Services;

import com.microservices.Abono.Domain.Model.Query.PaymentView;
import com.microservices.Abono.Domain.Repositories.Query.PaymentViewRepository;
import com.microservices.Abono.Domain.Services.PaymentViewService;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Service implementation for viewing the payment history of a patient.
 * This class interacts with the PaymentViewRepository to retrieve the payment history.
 */
@Component
public class PaymentViewServiceImpl implements PaymentViewService {
    private final PaymentViewRepository paymentViewRepository;

    public PaymentViewServiceImpl(PaymentViewRepository paymentViewRepository){
        this.paymentViewRepository = paymentViewRepository;
    }
    /**
     * Retrieves the payment history for a given patient by delegating the call to the repository.
     *
     * @param patientName The name of the patient whose payment history is requested.
     * @return A list of PaymentView objects representing the patient's payment history.
     */
    @Override
    public List<PaymentView> viewPaymentHistory(String patientName) {
        return paymentViewRepository.seePaymentHistory(patientName);
    }
}
