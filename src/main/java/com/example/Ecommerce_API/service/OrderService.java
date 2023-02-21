package com.example.Ecommerce_API.service;

import com.example.Ecommerce_API.dao.OrderRepository;
import com.example.Ecommerce_API.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public int makingOrder(Orders order){
        Orders orders = orderRepository.save(order);
        return orders.getOrdersId();
    }

    public Orders get(Integer ordersId) {
        Orders orders = orderRepository.findById(ordersId).get();
        return orderRepository.findById(ordersId).get();
    }
}
