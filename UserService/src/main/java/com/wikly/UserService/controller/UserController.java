package com.wikly.UserService.controller;

import com.wikly.UserService.model.User;
import com.wikly.UserService.repiository.UserRepository;
import com.wikly.UserService.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userservice")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @GetMapping("/api/v1/users")
    public ResponseEntity<List<User> >getAllUsers() {
        List<User> users = repository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/v1/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = repository.findByUserId(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/api/v1/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        user.setUserId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        repository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
