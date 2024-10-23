package com.microservices.Abono.Infrastructure.Adapters.Input;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.Abono.Application.Dto.NewPayment;
import com.microservices.Abono.Application.Services.SavePayments;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Listens for payment events from the Quotations microservice.
 * This component handles incoming messages related to first-time payments.
 */
@Component
public class PaymentListener {
    private final SavePayments savePayments;
    private final ObjectMapper objectMapper;

    public PaymentListener(SavePayments savePayments, ObjectMapper objectMapper) {
        this.savePayments = savePayments;
        this.objectMapper = objectMapper;
    }

    /**
     * Listens for messages on the "abonoPrimeraVez" queue and processes the first payment.
     *
     * @param newPayment the JSON string representing the new payment
     */
    @RabbitListener(queues = "abonoPrimeraVez")
    void storePaymentFirstTime(String newPayment) {
        try {

            NewPayment paymentNewPayment = objectMapper.readValue(newPayment, NewPayment.class);
            savePayments.firstPayment(paymentNewPayment);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
