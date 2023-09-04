package com.spring.l10springdetails.services;

import com.spring.l10springdetails.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void addProduct(String name) {
        productRepository.addProduct(name);
    }

}
