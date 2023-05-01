package com.wikly.CartService.repository;

import com.wikly.CartService.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<Cart, Integer> {
    List<Cart> findAllByUserId(int userId);
}
