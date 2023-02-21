package com.example.Ecommerce_API.controller;

import com.example.Ecommerce_API.dao.AddressRepository;
import com.example.Ecommerce_API.dao.ProductRepository;
import com.example.Ecommerce_API.dao.UserRepository;
import com.example.Ecommerce_API.model.Address;
import com.example.Ecommerce_API.model.Orders;
import com.example.Ecommerce_API.model.Product;
import com.example.Ecommerce_API.model.User;
import com.example.Ecommerce_API.service.OrderService;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AddressRepository addressRepository;

    @PostMapping("/placeOrder")
    public ResponseEntity placeOrder(@RequestBody String order){
        Orders order1 = setOrders(order);
        int response = orderService.makingOrder(order1);
        return new ResponseEntity<>("Order is placed with order ID as "+response, HttpStatus.CREATED);

    }

    private Orders setOrders(String orders){
        JSONObject json = new JSONObject(orders);
        Orders order = new Orders();

        int userId = json.getInt("userId");
        User user = null;
        if(userRepository.findById(userId).isPresent()){
            user = userRepository.findById(userId).get();
        }
        order.setUser(user);

        int productId = json.getInt("productId");
        Product product = null;
        if(productRepository.findById(productId).isPresent()){
            product = productRepository.findById(productId).get();
        }
        order.setProduct(product);

        int addressId = json.getInt("addressId");
        Address address = null;
        if(addressRepository.findById(addressId).isPresent()){
            address = addressRepository.findById(addressId).get();
        }
        order.setAddress(address);
        order.setOrdersId(json.getInt("ordersId"));
        order.setProductQuantity(json.getInt("productQuantity"));
        return order;
    }

    @GetMapping("/getOrder/{ordersId}")
    public Orders getOrders(@PathVariable Integer ordersId){
        return orderService.get(ordersId);
    }
}
