package com.example.Ecommerce_API.service;

import com.example.Ecommerce_API.dao.UserRepository;
import com.example.Ecommerce_API.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int addUser(User user){
        User userId = userRepository.save(user);
        return userId.getUserId();
    }

    public User get(Integer userId) {
        return userRepository.findById(userId).get();
    }
}
