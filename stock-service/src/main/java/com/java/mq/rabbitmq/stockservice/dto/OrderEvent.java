package com.java.mq.rabbitmq.stockservice.dto;

import java.util.Objects;

public class OrderEvent {
    private String status;
    private String message;
    private Order order;

    public OrderEvent() {
    }

    public OrderEvent(String status, String message, Order order) {
        this.status = status;
        this.message = message;
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderEvent that)) return false;
        return Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getOrder(), that.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getMessage(), getOrder());
    }
}
