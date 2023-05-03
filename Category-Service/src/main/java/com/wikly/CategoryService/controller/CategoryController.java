package com.wikly.CategoryService.controller;

import com.wikly.CategoryService.model.Category;
import com.wikly.CategoryService.repository.CategoryRepository;
import com.wikly.CategoryService.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoryservice")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @GetMapping("/api/v1/categories/{societyId}")
    public ResponseEntity<List<Category>> getCategories (@PathVariable int societyId) {
        List<Category> categories;
        try {
            categories = repository.findAll()
                    .stream()
                    .filter(category -> category.getSocieties().contains(societyId))
                    .collect(Collectors.toList());
        }
        catch (Exception e) {
            categories = new ArrayList<>();
        }

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/api/v1/addcategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        category.setCategoryId(sequenceGenerator.generateSequence(Category.SEQUENCE_NAME));
        return new ResponseEntity<>(repository.save(category), HttpStatus.CREATED);
    }
}
