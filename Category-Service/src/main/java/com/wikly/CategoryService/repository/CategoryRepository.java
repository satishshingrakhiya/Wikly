package com.wikly.CategoryService.repository;

import com.wikly.CategoryService.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, Integer> {
}
