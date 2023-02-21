package com.example.Ecommerce_API.service;

import com.example.Ecommerce_API.dao.AddressRepository;
import com.example.Ecommerce_API.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public int saveAddress(Address address){
        Address address1 = addressRepository.save(address);
        return address1.getAddressId();
    }
}
