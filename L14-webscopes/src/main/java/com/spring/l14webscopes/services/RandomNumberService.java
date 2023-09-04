package com.spring.l14webscopes.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)

/**
 *
 *     WebApplicationContext.SCOPE_REQUEST = "request";         --> this class will be instantiated for each request.
 *     WebApplicationContext.SCOPE_SESSION = "session";         --> this class will be instantiated for each session (per user). User 1 will have her/his own instance of this class. And user 2 will have her/his own instance of this class.
 *     WebApplicationContext.SCOPE_APPLICATION = "application"; --> this is singleton. this class will be instantiated once and be put into context.
 */

/**
 *  if the class or it's interface is not injected anywhere, then you don't have to specify proxyMode
 * ScopedProxyMode.TARGET_CLASS     --> this class must be injected directly as class @Scope annotation to work.
 * ScopedProxyMode.INTERFACES       --> this class must be injected via it's interface @Scope annotation to work. (see RandomNumberService2)
 */
public class RandomNumberService {

    private int randomNumber;

    public RandomNumberService(){
        this.randomNumber = new Random().nextInt(1000);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
