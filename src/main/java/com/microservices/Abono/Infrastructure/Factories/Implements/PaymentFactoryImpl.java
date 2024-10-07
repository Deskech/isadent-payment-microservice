package com.microservices.Abono.Infrastructure.Factories.Implements;

import com.microservices.Abono.Application.Dto.NewPayment;
import com.microservices.Abono.Domain.Factories.PaymentFactory;
import com.microservices.Abono.Domain.Model.CommandLine.Payment;
import com.microservices.Abono.Domain.Model.CommandLine.PaymentValues;
import com.microservices.Abono.Infrastructure.Services.Currency;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
/**
 * This class creates Payment objects from NewPayment data.
 * It prepares all the necessary information for creating a Payment.
 */
@Component
public class PaymentFactoryImpl implements PaymentFactory<NewPayment> {
    private final Currency currency;
    public PaymentFactoryImpl(Currency currency){
        this.currency= currency;
    }
    /**
     * Converts a NewPayment object that contains patient's name and payment amount into a Payment object.
     *
     * @param newPayment the NewPayment object containing payment details
     * @return a new Payment object ready for persistence
     */
    @Override
    public Payment create(NewPayment newPayment) {
        //first we create the necessary for creating the PaymentValues value Obj
        String paymentCurrency = currency.moneyFormat(newPayment.getPaymentValue());
        Double paymentValue = newPayment.getPaymentValue();
        String patientName = newPayment.getPatientName();
        PaymentValues paymentValues = new PaymentValues(paymentCurrency, paymentValue);
        LocalDate fecha = LocalDate.now();
        //we return the nue instance of Payment this is used for persistence
        return Payment.crearAbono(paymentValues, patientName, fecha);

    }
}
