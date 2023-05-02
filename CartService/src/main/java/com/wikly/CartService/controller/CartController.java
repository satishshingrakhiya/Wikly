package com.wikly.CartService.controller;

import com.wikly.CartService.model.Cart;
import com.wikly.CartService.repository.CartRepository;
import com.wikly.CartService.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartRepository repository;

    @Autowired
    SequenceGeneratorService sequenceGenerator;

    @GetMapping("api/v1/cartItems/{userId}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable int userId) {
        List<Cart> cartList = repository.findAllByUserId(userId);
        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @PostMapping("api/v1/addCartItem")
    public ResponseEntity<Cart> addCartItem(@RequestBody Cart cart) {
        cart.setCartId(sequenceGenerator.generateSequence(Cart.SEQUENCE_NAME));
        repository.save(cart);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }
}
