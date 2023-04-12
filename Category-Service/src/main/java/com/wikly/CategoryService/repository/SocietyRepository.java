package com.wikly.CategoryService.repository;

import com.wikly.CategoryService.model.Society;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocietyRepository extends MongoRepository<Society, Integer> {
}
