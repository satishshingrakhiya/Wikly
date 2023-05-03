package com.wikly.CategoryService.controller;

import com.wikly.CategoryService.model.Menu;
import com.wikly.CategoryService.repository.MenuRepository;
import com.wikly.CategoryService.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoryservice")
public class MenuController {
    @Autowired
    private MenuRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @GetMapping("/api/v1/menu/{categoryId}")
    public ResponseEntity<List<Menu>> getMenus(@PathVariable int categoryId) {
        List<Menu> menus = repository.findAllByCategoryId(categoryId);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @PostMapping("/api/v1/addmenu")
    public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
        menu.setMenuId(sequenceGenerator.generateSequence(Menu.SEQUENCE_NAME));
        repository.save(menu);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);
    }
}
