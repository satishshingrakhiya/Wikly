package com.wikly.CategoryService.controller;

import com.wikly.CategoryService.model.Society;
import com.wikly.CategoryService.repository.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocietyController {

    @Autowired
    private SocietyRepository repository;

    @GetMapping("api/v1/societies")
    public ResponseEntity<List<Society>> getSocieties() {
        List<Society> societies = repository.findAll();
        return new ResponseEntity<>(societies, HttpStatus.OK);
    }

    @PostMapping("api/v1/society")
    public ResponseEntity<Society> addSociety(@RequestBody Society society) {
        repository.save(society);
        return new ResponseEntity<>(society, HttpStatus.CREATED);
    }
}
