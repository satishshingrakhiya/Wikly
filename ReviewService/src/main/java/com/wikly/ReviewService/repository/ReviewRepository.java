package com.wikly.ReviewService.repository;

import com.wikly.ReviewService.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, Integer> {
    List<Review> findAllByCategoryId(int categoryId);
}
