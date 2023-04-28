package com.wikly.OrderService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "Order")
public class Order {
    @Id
    private int orderId;
    private int userId;
    private String orderStatus;
    private LocalDate orderedOn;
    private LocalDate deliveredOn;
    private List<Item> items;
}
