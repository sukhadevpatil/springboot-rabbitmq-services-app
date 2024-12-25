package com.java.mq.rabbitmq.stockservice.consumer;

import com.java.mq.rabbitmq.stockservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderStockConsumer {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(OrderStockConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.order.name}")
    public void processOrder(OrderEvent orderEvent) {
        LOGGER.info("Order Event => {}", orderEvent.toString());
    }
}
