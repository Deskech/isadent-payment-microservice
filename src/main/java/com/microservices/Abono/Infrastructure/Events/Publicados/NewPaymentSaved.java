package com.microservices.Abono.Infrastructure.Events.Publicados;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.Abono.Domain.Model.CommandLine.Payment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
/**
 * Publishes new payment events to the message queue for processing.
 * This component converts payment objects to JSON and sends them to the "ultimoPago" queue.
 */
@Component
public class NewPaymentSaved {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    public NewPaymentSaved(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper){
        this.rabbitTemplate= rabbitTemplate;
        this.objectMapper= objectMapper;
    }
    /**
     * Reports a new payment event to the query line by sending it to the message queue.
     *
     * @param payment the Payment object to be reported
     */
    public void reportEventToQueryLine(Payment payment){
        try {
            String json = objectMapper.writeValueAsString(payment);
            rabbitTemplate.convertAndSend("ultimoPago","nuevoAbono",json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
