package com.java.mq.rabbitmq.emailservice.consumer;

import com.java.mq.rabbitmq.emailservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEmailConsumer {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(OrderEmailConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void consume(OrderEvent orderEvent) {
        LOGGER.info("Order Email Event => {}", orderEvent.toString());
    }
}
