package com.github.mattnicee7.services;

import com.github.mattnicee7.entities.Order;
import com.github.mattnicee7.entities.User;
import com.github.mattnicee7.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        return order.get();
    }

}
