package com.spring.l11springdata.services;

import com.spring.l11springdata.entities.Product;
import com.spring.l11springdata.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product getProduct(String name){
        return productRepository.findByName(name);
    }

}
