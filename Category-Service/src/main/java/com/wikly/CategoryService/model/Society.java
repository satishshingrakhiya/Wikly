package com.wikly.CategoryService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Society")
public class Society {
    @Transient
    public static final String SEQUENCE_NAME = "society_sequence";
    @Id
    private int societyId;
    private String societyName;
    private String city;
    private int pinCode;
}
