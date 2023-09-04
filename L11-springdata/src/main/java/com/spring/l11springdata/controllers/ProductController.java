package com.spring.l11springdata.controllers;

import com.spring.l11springdata.entities.Product;
import com.spring.l11springdata.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping("/get/{productName}")
    public Product getProduct(@PathVariable("productName") String name){
        return productService.getProduct(name);
    }

}
