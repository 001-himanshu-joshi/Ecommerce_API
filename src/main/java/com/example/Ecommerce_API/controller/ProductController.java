package com.example.Ecommerce_API.controller;

import com.example.Ecommerce_API.model.Product;
import com.example.Ecommerce_API.model.User;
import com.example.Ecommerce_API.service.ProductService;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody String product){
        Product product1 = setProduct(product);
        int response = productService.saveProduct(product1);
        return new ResponseEntity<>("Product is added with Product ID as "+response, HttpStatus.CREATED);
    }

    @GetMapping("/getProducts")
    public List<Product> getProduct(){
        return productService.get();
    }
    @GetMapping("/getProduct")
    public Product get(@RequestParam String category){
        return productService.getByCategory(category);
    }
    @DeleteMapping("/deleteProduct/productId")
    public ResponseEntity deleteProduct(@PathVariable Integer productId){
        String response = productService.delete(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private Product setProduct(String product){
        JSONObject json = new JSONObject(product);
        Product newProduct = new Product();
        newProduct.setProductId(json.getInt("productId"));
        newProduct.setProductName(json.getString("productName"));
        newProduct.setPrice(json.getInt("price"));
        newProduct.setBrand(json.getString("brand"));
        newProduct.setCategory(json.getString("category"));
        newProduct.setDescription(json.getString("description"));
        return newProduct;
    }
}
