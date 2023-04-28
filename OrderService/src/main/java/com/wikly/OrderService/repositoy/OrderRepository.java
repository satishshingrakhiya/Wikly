package com.wikly.OrderService.repositoy;

import com.wikly.OrderService.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    List<Order> findAllByUserId(int userId);
}
