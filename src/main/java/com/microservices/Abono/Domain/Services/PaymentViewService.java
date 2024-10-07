package com.microservices.Abono.Domain.Services;

import com.microservices.Abono.Domain.Model.Query.PaymentView;

import java.util.List;

/**
 * This domain services returns a formatted view of the
 * payment history
 */
public interface PaymentViewService {
    /**
     *
     * @param patientName who has paid
     * @return a list of payments
     */
    List<PaymentView> viewPaymentHistory(String patientName);
}
