package com.wikly.OrderService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderedOn;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveredOn;
    private List<Item> items;
}
