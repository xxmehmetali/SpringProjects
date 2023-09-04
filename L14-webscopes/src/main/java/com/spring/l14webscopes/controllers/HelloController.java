package com.spring.l14webscopes.controllers;

import com.spring.l14webscopes.services.NumberService;
import com.spring.l14webscopes.services.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    //RandomNumberService type will be proxy because of @Scope annotation.
    @Autowired
    private RandomNumberService randomNumberService;

    //NumberService type will be also proxy because of @Scope annotation.
    @Autowired
    private NumberService numberService2;

    @GetMapping("/hello")
    public String index(Model model){
        model.addAttribute("randomNumberFromRandomNumberService", randomNumberService.getRandomNumber());
        model.addAttribute("randomNumberFromNumberService2", numberService2.getRandomNumber());
        return "index.html";
    }
}
