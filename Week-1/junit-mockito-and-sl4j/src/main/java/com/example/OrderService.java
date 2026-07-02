package com.example;

public class OrderService {

    private final OrderRepository orderRepository;
    private final MessageSender messageSender;

    public OrderService(OrderRepository orderRepository, MessageSender messageSender) {
        this.orderRepository = orderRepository;
        this.messageSender = messageSender;
    }

    public String saveOrder(String item) {
        orderRepository.save(item);
        messageSender.send("Saved " + item);
        return orderRepository.nextReference();
    }

    public String findOrder(int id) {
        return orderRepository.findById(id);
    }
}
