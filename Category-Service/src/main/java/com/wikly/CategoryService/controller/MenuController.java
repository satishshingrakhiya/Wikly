package com.wikly.CategoryService.controller;

import com.wikly.CategoryService.model.Menu;
import com.wikly.CategoryService.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuRepository repository;

    @GetMapping("api/v1/menu/{categoryId}")
    public ResponseEntity<List<Menu>> getMenus(@PathVariable int categoryId) {
        List<Menu> menus = repository.findAllByCategoryId(categoryId);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @PostMapping("api/v1/addMenu")
    public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
        return new ResponseEntity<>(repository.save(menu), HttpStatus.CREATED);
    }
}
