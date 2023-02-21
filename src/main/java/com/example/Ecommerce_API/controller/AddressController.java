package com.example.Ecommerce_API.controller;

import com.example.Ecommerce_API.dao.AddressRepository;
import com.example.Ecommerce_API.dao.UserRepository;
import com.example.Ecommerce_API.model.Address;
import com.example.Ecommerce_API.model.User;
import com.example.Ecommerce_API.service.AddressService;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressService addressService;

    @PostMapping("/addAddress")
    public ResponseEntity addAddress(@RequestBody String address){
        Address address1 = setAddress(address);
        int response = addressService.saveAddress(address1);
        return  new ResponseEntity<>("Address is with Address ID as "+response, HttpStatus.CREATED);
    }
    private Address setAddress(String address1){
        JSONObject json = new JSONObject(address1);
        int userId = json.getInt("userId");
        User user = null;
        if(userRepository.findById(userId).isPresent()){
            user = userRepository.findById(userId).get();
        }
        Address address = new Address();
        address.setUser(user);
        address.setAddressId(json.getInt("addressId"));
        address.setAddressName(json.getString("addressName"));
        address.setLandmark(json.getString("landmark"));
        address.setState(json.getString("state"));
        address.setPhoneNumber(json.getString("phoneNumber"));
        address.setZipCode(json.getString("zipCode"));
        return address;
    }
}
