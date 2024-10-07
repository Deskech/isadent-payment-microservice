package com.microservices.Abono.Infrastructure.Services;

import com.microservices.Abono.Application.Dto.NewPayment;
import com.microservices.Abono.Domain.Events.LastPayment;
import com.microservices.Abono.Domain.Factories.PaymentFactory;
import com.microservices.Abono.Domain.Model.CommandLine.Payment;
import com.microservices.Abono.Domain.Repositories.CommandLine.PaymentRepository;
import com.microservices.Abono.Domain.Services.SavePayment;
import com.microservices.Abono.Infrastructure.Events.Publicados.NewPaymentSaved;
import org.springframework.stereotype.Component;
/**
 * Implementation of the SavePayment interface for handling payment registrations.
 * This class saves both first-time and subsequent payments, interacting with different layers such as factories and repositories.
 *
 */
@Component
public class SavePaymentImpl implements SavePayment<NewPayment> {
    private final PaymentFactory<NewPayment> paymentFactory;
    private final PaymentRepository<Payment> paymentRepository;
    private final NewPaymentSaved newPaymentSaved;
    private final LastPayment<NewPayment> lastPayment;
    public SavePaymentImpl(PaymentFactory<NewPayment> paymentFactory, PaymentRepository<Payment> paymentRepository, NewPaymentSaved newPaymentSaved,
                           LastPayment<NewPayment> lastPayment
                            ) {
        this.paymentFactory = paymentFactory;
        this.paymentRepository = paymentRepository;
        this.newPaymentSaved = newPaymentSaved;
        this.lastPayment = lastPayment;
    }
    /**
     * Saves a new payment by creating a payment entity, registering it, and reporting it.
     *
     * @param paymentToRegister The payment details to be registered.
     * @throws InternalError If there is an internal error during the payment process.
     */
    @Override
    public void savePayment(NewPayment paymentToRegister) {
        try {
            Payment newPayment = paymentFactory.create(paymentToRegister);
            paymentRepository.registerPayment(newPayment);
            newPaymentSaved.reportEventToQueryLine(newPayment);
            lastPayment.reportLastPayment(paymentToRegister);
        } catch (InternalError e) {
            throw new InternalError(e);
        }

    }
    /**
     * Saves the first payment for a patient by creating a payment entity and registering it as a first-time payment.
     *
     * @param paymentToRegister The first payment details to be registered.
     * @throws InternalError If there is an internal error during the first payment process.
     */
    @Override
    public void saveFirstPayment(NewPayment paymentToRegister) {
        try {
            Payment newPayment = paymentFactory.create(paymentToRegister);
            paymentRepository.registerFirstPayment(newPayment);
            newPaymentSaved.reportEventToQueryLine(newPayment);
        } catch (InternalError e) {
            throw new InternalError(e);
        }

    }
}
