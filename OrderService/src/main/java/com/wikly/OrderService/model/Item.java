package com.wikly.OrderService.model;

import lombok.Data;

@Data
public class Item {
    private String itemName;
    private int quantity;
    private int amount;
    private int rate;
}
