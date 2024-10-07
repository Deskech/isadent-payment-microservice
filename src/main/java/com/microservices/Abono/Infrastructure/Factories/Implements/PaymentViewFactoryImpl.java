package com.microservices.Abono.Infrastructure.Factories.Implements;

import com.microservices.Abono.Domain.Factories.PaymentViewFactory;
import com.microservices.Abono.Domain.Model.Query.PaymentView;
import com.microservices.Abono.Infrastructure.Entities.Query.QueryPaymentEntity;
import org.springframework.stereotype.Component;
/**
 * This class creates PaymentView objects from QueryPaymentEntity data.
 * It transforms data from the database into a format suitable for displaying payment information.
 */
@Component
public class PaymentViewFactoryImpl implements PaymentViewFactory<QueryPaymentEntity> {
    /**
     * Converts a QueryPaymentEntity into a PaymentView so the user can see the payment history from a domain model.
     *
     * @param paymentView the QueryPaymentEntity containing payment details
     * @return a new PaymentView object with formatted payment information
     */
    @Override
    public PaymentView create(QueryPaymentEntity paymentView) {
        // we get the necessary values to map a PaymentView instance
        String paymentCurrency = paymentView.getPaymentCurrency();
        String patientName = paymentView.getPatientName();
        String paymentDate = paymentView.getPaymentDate().toString();
        // return a new PaymentView instance
        return new PaymentView(paymentCurrency, patientName, paymentDate);
    }
}
