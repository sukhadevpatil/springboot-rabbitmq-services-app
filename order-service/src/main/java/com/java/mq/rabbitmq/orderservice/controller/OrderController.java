package com.java.mq.rabbitmq.orderservice.controller;

import com.java.mq.rabbitmq.orderservice.dto.Order;
import com.java.mq.rabbitmq.orderservice.dto.OrderEvent;
import com.java.mq.rabbitmq.orderservice.publisher.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {

        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent("PENDING", "Order is in Pending State", order);

        orderProducer.sendMessage(orderEvent);
        return "Order Placed Successfully";
    }
}
