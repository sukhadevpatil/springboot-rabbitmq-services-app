package com.java.mq.rabbitmq.orderservice.publisher;

import com.java.mq.rabbitmq.orderservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(OrderProducer.class);

    @Value("${rabbitmq.queue.order.exchange}")
    private String orderExchange;

    @Value("${rabbitmq.queue.order.routing_key}")
    private String orderRoutingKey;

    @Value("${rabbitmq.queue.email.routing_key}")
    private String emailRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderEvent orderEvent) {
        LOGGER.info("Order Event => {}", orderEvent.toString());

        //send to order queue
        rabbitTemplate.convertAndSend(orderExchange, orderRoutingKey, orderEvent);

        //send to email queue
        rabbitTemplate.convertAndSend(orderExchange, emailRoutingKey, orderEvent);
    }
}
