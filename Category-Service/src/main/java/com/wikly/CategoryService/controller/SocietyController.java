package com.wikly.CategoryService.controller;

import com.wikly.CategoryService.model.Society;
import com.wikly.CategoryService.repository.SocietyRepository;
import com.wikly.CategoryService.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoryservice")
public class SocietyController {

    @Autowired
    private SocietyRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @GetMapping("api/v1/societies")
    @CrossOrigin
    public ResponseEntity<List<Society>> getSocieties() {
        List<Society> societies = repository.findAll();
        return new ResponseEntity<>(societies, HttpStatus.OK);
    }

    @PostMapping("api/v1/addsociety")
    public ResponseEntity<Society> addSociety(@RequestBody Society society) {
        society.setSocietyId(sequenceGenerator.generateSequence(Society.SEQUENCE_NAME));
        repository.save(society);
        return new ResponseEntity<>(society, HttpStatus.CREATED);
    }
}
