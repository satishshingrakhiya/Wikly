package com.wikly.OrderService.controller;

import com.wikly.OrderService.model.Order;
import com.wikly.OrderService.repositoy.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @GetMapping("api/v1/orders/{userId}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable int userId) {
        List<Order> orders = repository.findAllByUserId(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("api/v1/addOrder")
    public ResponseEntity<Order> addOrder (@RequestBody Order order) {
        repository.save(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
