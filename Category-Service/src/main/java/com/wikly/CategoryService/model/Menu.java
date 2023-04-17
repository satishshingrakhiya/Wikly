package com.wikly.CategoryService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "Menu")
public class Menu {
    @Id
    private int menuId;
    private int categoryId;
    private String MenuName;
    private List<Map<String, Integer>> availableIn;
    private String unit;
}
