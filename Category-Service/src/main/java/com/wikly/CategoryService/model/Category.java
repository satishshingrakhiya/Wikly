package com.wikly.CategoryService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document(collection = "Category")
public class Category {
    @Id
    private int categoryId;
    private String categoryName;
    private int discount;
    private int buyers;
    private List<Integer> societies;
}
