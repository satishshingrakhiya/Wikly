package com.wikly.ReviewService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Review")
public class Review {
    @Transient
    public static final String SEQUENCE_NAME = "review_sequence";
    @Id
    private int reviewId;
    private int categoryId;
    private String userName;
    private String societyName;
    private int rating;
    private String description;
}
