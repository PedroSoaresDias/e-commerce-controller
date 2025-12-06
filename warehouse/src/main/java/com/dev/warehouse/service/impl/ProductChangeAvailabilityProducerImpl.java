package com.dev.warehouse.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.dev.warehouse.domain.dto.StockStatusMessage;
import com.dev.warehouse.service.IProductChangeAvaliabilityProducer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductChangeAvailabilityProducerImpl implements IProductChangeAvaliabilityProducer {
    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName = "product.change.availability.exchange";
    private final String routingKeyName = "product.change.availability.routing.key";

    @Override
    public void notifyStatusChange(StockStatusMessage message) {
        rabbitTemplate.convertAndSend(exchangeName, routingKeyName, message);
    }

}
