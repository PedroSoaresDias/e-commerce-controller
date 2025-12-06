package com.dev.warehouse.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class AMQPConfig {

    private static final String PRODUCT_CHANGE_AVAILABILITY_QUEUE = "product.change.availability.queue";
    private static final String PRODUCT_CHANGE_AVAILABILITY_EXCHANGE = "product.change.availability.exchange";
    private static final String PRODUCT_CHANGE_AVAILABILITY_ROUTING_KEY = "product.change.availability.routing.key";

    @Bean
    Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(@NonNull ConnectionFactory connectionFactory,
            @NonNull Jackson2JsonMessageConverter converter) {
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }

    @Bean
    Queue queue() {
        return new Queue(PRODUCT_CHANGE_AVAILABILITY_QUEUE, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(PRODUCT_CHANGE_AVAILABILITY_EXCHANGE);
    }

    @Bean
    Binding binding(final Queue queue, final DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(PRODUCT_CHANGE_AVAILABILITY_ROUTING_KEY);
    }
}
