package com.wikly.UserService.repiository;

import com.wikly.UserService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
    User findByUserId(int userId);
}

