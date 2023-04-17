package com.wikly.CategoryService.controller;

import com.wikly.CategoryService.model.Category;
import com.wikly.CategoryService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping("api/v1/categories/{societyId}")
    public ResponseEntity<List<Category>> getCategories (@PathVariable int societyId) {
        List<Category> categories = repository.findAll()
                .stream()
                .filter(category -> category.getSocieties().contains(societyId))
                .collect(Collectors.toList());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("api/v1/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(repository.save(category), HttpStatus.CREATED);
    }
}