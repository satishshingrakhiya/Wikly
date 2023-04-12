package com.wikly.CategoryService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Society")
public class Society {
    @Id
    private int societyId;
    private String societyName;
    private String city;
    private int pinCode;
}
