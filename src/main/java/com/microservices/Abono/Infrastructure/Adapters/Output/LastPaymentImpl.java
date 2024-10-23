package com.microservices.Abono.Infrastructure.Adapters.Output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.Abono.Application.Dto.NewPayment;
import com.microservices.Abono.Domain.Events.LastPayment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Implementation of the LastPayment interface for reporting the last payment.
 * This component sends the last payment information to a message queue.
 */
@Component
public class LastPaymentImpl implements LastPayment<NewPayment> {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public LastPaymentImpl(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    /**
     * Reports the last payment by sending it to the message queue.
     *
     * @param lastPayment the last payment object to be reported
     */
    @Override
    public void reportLastPayment(NewPayment lastPayment) {
        try {
            String json = objectMapper.writeValueAsString(lastPayment);
            rabbitTemplate.convertAndSend("ultimoPago", "ultimoPago", json);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
