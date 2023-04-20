package com.wikly.ReviewService.controller;

import com.wikly.ReviewService.model.Review;
import com.wikly.ReviewService.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewRepository repository;

    @GetMapping("api/v1/reviews/{categoryId}")
    public ResponseEntity<List<Review>> getReview(@PathVariable int categoryId) {
        List<Review> reviews = repository.findAllByCategoryId(categoryId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping("api/v1/addReview")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return new ResponseEntity<>(repository.save(review), HttpStatus.CREATED);
    }
}