package com.microservices.Abono.Infrastructure.Events.Ocurridos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.Abono.Domain.Model.CommandLine.Payment;
import com.microservices.Abono.Infrastructure.Entities.Query.QueryPaymentEntity;
import com.microservices.Abono.Infrastructure.Factories.Interfaces.FactoryQueryPaymentEntity;
import com.microservices.Abono.Infrastructure.Repositories.Query.QueryPaymentActualization;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * Listens for new payment events from the command line database
 * This component updates the payment queries based on received payment data.
 */
@Component
public class NewPaymentListener {
    private final QueryPaymentActualization queryPaymentActualization;
    private final FactoryQueryPaymentEntity<Payment> factoryQueryPaymentEntity;
    private final ObjectMapper objectMapper;
    public NewPaymentListener(QueryPaymentActualization queryPaymentActualization, FactoryQueryPaymentEntity<Payment> factoryQueryPaymentEntity,
                              ObjectMapper objectMapper
                              ) {
        this.queryPaymentActualization = queryPaymentActualization;
        this.factoryQueryPaymentEntity = factoryQueryPaymentEntity;
        this.objectMapper= objectMapper;
    }
    /**
     * Listens for messages on the "abonoOcurrido" queue and updates the query with the payment information.
     *
     * @param payment the JSON string representing the payment comming from the command line database
     */
    @RabbitListener(queues = "abonoOcurrido")
    public void actualizarQuery(String payment) {
        try {
            System.out.println("payment escuchado" + payment);
            Payment abonos = objectMapper.readValue(payment, Payment.class);
            QueryPaymentEntity queryPaymentEntity = factoryQueryPaymentEntity.create(abonos);
            queryPaymentActualization.save(queryPaymentEntity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
