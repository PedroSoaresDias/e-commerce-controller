package com.dev.warehouse.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dev.warehouse.domain.dto.StockStatusMessage;
import com.dev.warehouse.service.IProductChangeAvaliabilityProducer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductChangeAvailabilityProducerImpl implements IProductChangeAvaliabilityProducer {
    private final RabbitTemplate rabbitTemplate;
    @Value("product.change.availability.exchange")
    private final String exchangeName;
    @Value("product.change.availability.routing.key")
    private final String routingKeyName;

    @Override
    public void notifyStatusChange(StockStatusMessage message) {
        rabbitTemplate.convertAndSend(exchangeName, routingKeyName, message);
    }

}
