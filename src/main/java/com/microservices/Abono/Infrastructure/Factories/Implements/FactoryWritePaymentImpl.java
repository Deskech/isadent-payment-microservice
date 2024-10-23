package com.microservices.Abono.Infrastructure.Factories.Implements;

import com.microservices.Abono.Domain.Model.CommandLine.Payment;
import com.microservices.Abono.Infrastructure.Entities.CommandLine.WritePaymentEntity;
import com.microservices.Abono.Infrastructure.Factories.Interfaces.FactoryWritePaymentEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * This class creates WritePaymentEntity objects from Payment data.
 * It converts Payment information into a format suitable for saving to the database.
 */
@Component
public class FactoryWritePaymentImpl implements FactoryWritePaymentEntity<Payment> {
    /**
     * Converts a Payment object into a WritePaymentEntity.
     *
     * @param payment the Payment object with payment details
     * @return a new WritePaymentEntity filled with information from the Payment object
     */
    @Override
    public WritePaymentEntity create(Payment payment) {
        WritePaymentEntity writePaymentEntity = new WritePaymentEntity();
        writePaymentEntity.setPaymentValue(payment.getPaymentValues().getPaymentValue());
        writePaymentEntity.setPaymentCurrency(payment.getPaymentValues().getPaymentCurrency());
        writePaymentEntity.setPatientName(payment.getPatientName());
        writePaymentEntity.setPaymentDate(LocalDate.now());
        return writePaymentEntity;
    }
}
