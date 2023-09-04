package com.spring.l14webscopes.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public class RandomNumberService2 implements NumberService{

    private int randomNumber;

    public RandomNumberService2(){
        this.randomNumber = new Random().nextInt(1000,2000);
    }

    @Override
    public int getRandomNumber() {
        return randomNumber;
    }
}
