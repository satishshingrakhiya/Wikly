package com.wikly.CategoryService.repository;

import com.wikly.CategoryService.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuRepository extends MongoRepository<Menu, Integer> {
    List<Menu> findAllByCategoryId(int categoryId);
}
