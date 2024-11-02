package com.microservices.Abono.Infrastructure.Events.Occurred;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.Abono.Domain.Model.CommandLine.Payment;
import com.microservices.Abono.Infrastructure.Entities.Query.QueryPaymentEntity;
import com.microservices.Abono.Infrastructure.Factories.Interfaces.FactoryQueryPaymentEntity;
import com.microservices.Abono.Infrastructure.Repositories.Query.QueryPaymentActualization;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * This class listens all the events occurred y the command line database
 */
@Slf4j
@Component
public class NewPaymentOccurred implements ChannelAwareMessageListener {
    private final QueryPaymentActualization payment;
    private final ObjectMapper objectMapper;
    private final FactoryQueryPaymentEntity<Payment> factoryQueryPayment;

    public NewPaymentOccurred(QueryPaymentActualization payment, ObjectMapper objectMapper, FactoryQueryPaymentEntity<Payment> factoryQueryPayment) {
        this.payment = payment;
        this.objectMapper = objectMapper;
        this.factoryQueryPayment = factoryQueryPayment;
    }

    /**
     *
     * @param message represents the message sent
     * @param channel represents the channel
     * @throws Exception if an error has happened
     */
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            Payment abonos = objectMapper.readValue(message.getBody(), Payment.class);
            QueryPaymentEntity queryPaymentEntity = factoryQueryPayment.create(abonos);
            payment.save(queryPaymentEntity);
            if (channel != null) {
                channel.basicAck(deliveryTag, false);
            }
            log.info("Message processed for delivery tag: {}", deliveryTag);
        } catch (JsonProcessingException e) {
            channel.basicNack(deliveryTag, false, true);
            log.error("Failed to process message for:{}", deliveryTag, e);
            throw new RuntimeException(e);
        }
    }
}
