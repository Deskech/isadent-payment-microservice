package com.microservices.Abono.Infrastructure.Factories.Implements;

import com.microservices.Abono.Domain.Model.CommandLine.Payment;
import com.microservices.Abono.Infrastructure.Entities.Query.QueryPaymentEntity;
import com.microservices.Abono.Infrastructure.Factories.Interfaces.FactoryQueryPaymentEntity;
import org.springframework.stereotype.Component;

/**
 * Factory implementation for creating QueryPaymentEntity objects from Payment data.
 * This component is responsible for converting payment objects into query entities for database operations.
 */
@Component
public class FactoryQueryEntity implements FactoryQueryPaymentEntity<Payment> {
    /**
     * Creates a QueryPaymentEntity based on the provided Payment object.
     *
     * @param payment the Payment object containing payment details
     * @return a new QueryPaymentEntity populated with data from the Payment object
     */
    @Override
    public QueryPaymentEntity create(Payment payment) {
        QueryPaymentEntity queryPaymentEntity = new QueryPaymentEntity();
        queryPaymentEntity.setPaymentCurrency(payment.getPaymentValues().getPaymentCurrency());
        queryPaymentEntity.setPatientName(payment.getPatientName());
        queryPaymentEntity.setPaymentDate(payment.getDate());
        return queryPaymentEntity;
    }
}
