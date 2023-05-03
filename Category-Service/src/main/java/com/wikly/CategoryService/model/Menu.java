package com.wikly.CategoryService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "Menu")
public class Menu {
    @Transient
    public static final String SEQUENCE_NAME = "menu_sequence";
    @Id
    private int menuId;
    private int categoryId;
    private String menuName;
    private List<Map<String, Integer>> availableIn;
    private String unit;
}
