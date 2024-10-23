package com.microservices.Abono.Infrastructure.Persistance.CommandLine;


import com.microservices.Abono.Domain.Model.CommandLine.Payment;
import com.microservices.Abono.Domain.Repositories.CommandLine.PaymentRepository;
import com.microservices.Abono.Infrastructure.Entities.CommandLine.WritePaymentEntity;
import com.microservices.Abono.Infrastructure.Factories.Interfaces.FactoryWritePaymentEntity;
import com.microservices.Abono.Infrastructure.Repositories.CommandLine.WriteJpaFirstTimePayment;
import com.microservices.Abono.Infrastructure.Repositories.CommandLine.WritePaymentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the PaymentRepository interface for handling payment-related operations.
 * This class interacts with the database to register payments, including first-time and subsequent payments.
 */
@Component
public class PaymentRepositoryImpl implements PaymentRepository<Payment> {
    private final WritePaymentRepository writePaymentRepository;
    private final WriteJpaFirstTimePayment writeJpaFirstTimePayment;
    private final FactoryWritePaymentEntity<Payment> writeAbonoFactory;

    public PaymentRepositoryImpl(WriteJpaFirstTimePayment writeJpaFirstTimePayment, WritePaymentRepository writePaymentRepository,
                                 FactoryWritePaymentEntity<Payment> writeAbonoFactory
    ) {
        this.writeJpaFirstTimePayment = writeJpaFirstTimePayment;
        this.writePaymentRepository = writePaymentRepository;
        this.writeAbonoFactory = writeAbonoFactory;

    }

    /**
     * Registers a payment for an existing patient. Throws an exception if the patient is not registered.
     *
     * @param payment The payment details to be registered.
     * @throws IllegalArgumentException if the patient is not registered.
     */
    @Transactional
    @Override
    public void registerPayment(Payment payment) {
        boolean patientName = writePaymentRepository.existsByPatientName(payment.getPatientName());
        if (!patientName) {
            throw new IllegalArgumentException("The patient has to be registered first");
        }
        writePaymentRepository.registerLastPayment(payment.getPaymentValues().getPaymentValue(), payment.getPaymentValues().getPaymentCurrency(),
                payment.getPatientName(), payment.getDate());
    }

    /**
     * Registers the first payment for a patient. This method saves the payment entity using a JPA repository.
     * This method is used in the Quotations microservice listener.
     *
     * @param newPayment The first payment details to be registered.
     */
    @Transactional
    @Override
    public void registerFirstPayment(Payment newPayment) {
        WritePaymentEntity entity = writeAbonoFactory.create(newPayment);
        writeJpaFirstTimePayment.save(entity);
    }
}
