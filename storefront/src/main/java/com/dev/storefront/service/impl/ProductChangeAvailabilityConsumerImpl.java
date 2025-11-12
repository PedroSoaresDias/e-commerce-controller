package com.dev.storefront.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.dev.storefront.domain.dto.StockStatusMessage;
import com.dev.storefront.service.IProductChangeAvailabilityConsumer;
import com.dev.storefront.service.IProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductChangeAvailabilityConsumerImpl implements IProductChangeAvailabilityConsumer {

    private final IProductService service;

    @RabbitListener(queues = "${spring.rabbitmq.queue.product-change-availability}")
    @Override
    public void receive(StockStatusMessage message) {
        service.changeActivated(message.id(), message.active());
    }

}
