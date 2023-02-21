package com.example.Ecommerce_API.controller;


import com.example.Ecommerce_API.model.User;
import com.example.Ecommerce_API.service.UserService;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity saveUser(@RequestBody String user){
        User newUser = setUser(user);
        int response = userService.addUser(newUser);
        return new ResponseEntity<>("User is added to database having ID "+response, HttpStatus.CREATED);
    }
    private User setUser(String user){
        JSONObject json = new JSONObject(user);
        User newUser = new User();
        newUser.setUserId(json.getInt("userId"));
        newUser.setName(json.getString("name"));
        newUser.setEmail(json.getString("email"));
        newUser.setPassword(json.getString("password"));
        newUser.setPhoneNumber(json.getString("phoneNumber"));
        return newUser;
    }
}

