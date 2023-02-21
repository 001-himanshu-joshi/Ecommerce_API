package com.example.Ecommerce_API.service;

import com.example.Ecommerce_API.dao.ProductRepository;
import com.example.Ecommerce_API.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public int saveProduct(Product product){
        Product product1 = productRepository.save(product);
        return product1.getProductId();
    }

    public List<Product> get() {
        return productRepository.findAll();
    }

    public String delete(Integer productId) {
        productRepository.deleteById(productId);
        return "Product is Deleted";
    }

    public Product getByCategory(String category) {
        List<Product> products = productRepository.findAll();
        Product newproduct = null;
        for(Product product : products){
            if(product.getCategory().equals(category)){
               newproduct = product;
            }
        }
        return newproduct;
    }
}
