package com.wikly.CartService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Cart")
public class Cart {
    @Transient
    public static final String SEQUENCE_NAME = "cart_sequence";
    @Id
    private int cartId;
    private int userId;
    private String itemName;
    private int amount;
    private int quantity;
    private int rate;
}
