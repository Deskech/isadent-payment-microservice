package com.microservices.Abono.Domain.Repositories.Query;

import com.microservices.Abono.Domain.Model.Query.PaymentView;

import java.util.List;

/**
 * This repository queries a list of payments the patients has done over time.
 */
public interface PaymentViewRepository {
    /**
     *
     * @param patientName references the patient's name payments
     * @return history of payments
     */
    List<PaymentView> seePaymentHistory(String patientName);
}
