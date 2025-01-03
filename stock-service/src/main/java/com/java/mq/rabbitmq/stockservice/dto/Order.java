package com.java.mq.rabbitmq.stockservice.dto;

import java.util.Objects;

public class Order {
    private String orderId;
    private String name;
    private int quantity;
    private double price;

    public Order() {
    }

    public Order(String orderId, String name, int quantity, double price) {
        this.orderId = orderId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return getQuantity() == order.getQuantity() && Double.compare(getPrice(), order.getPrice()) == 0 && Objects.equals(getOrderId(), order.getOrderId()) && Objects.equals(getName(), order.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getName(), getQuantity(), getPrice());
    }
}
