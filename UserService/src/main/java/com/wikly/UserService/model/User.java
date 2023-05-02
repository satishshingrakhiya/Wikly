package com.wikly.UserService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "User")
public class User {
    @Id
    private int userId;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private List<Address> addresses;
}
