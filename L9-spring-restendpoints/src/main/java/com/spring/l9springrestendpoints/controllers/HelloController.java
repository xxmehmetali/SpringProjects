package com.spring.l9springrestendpoints.controllers;

import com.spring.l9springrestendpoints.dtos.Person;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//Note that @RestController annotation is not a stereotype annotation but it puts the class into context
//Because it consists @Controller annotation and @Controller annotation also consists @Component annotation.
//This chain gains @RestConroller annotation the ability of putting class into context.

//stereotype annotations : Component, Controller, Indexed, Repository, Service
@RestController // or @Controller + @ResponseBody
public class HelloController {

    //default method is RequestMethod.GET
    @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    public String hello(@PathVariable(name = "name") final String name){
        return "Hello " + name;
    }

    //@GetMapping consists of @RequestMapping but method property is defined as RequestMethod.GET
    //Because it consists of @RequestMapping, it will have all the props of @RequestMapping like path and etc..
    @GetMapping(path = "/hello2/{name}")
    public String hello2(@PathVariable(name = "name") final String name){
        return "Hello " + name;
    }

    //@RequestBody gets the body of request and matches the content with pojo class that we have.
    @PostMapping(path = "/goodbye")
    public String goodbye(@RequestBody Person person){
        return "Goodbye " + person.getName();
    }

    @GetMapping("/getPerson")
    public Person getPerson(){
        Person person = new Person();
        person.setName("Bill");
        return person;
    }

    @GetMapping("/getPeople")
    public List<Person> getPeople(){
        Person person = new Person();
        person.setName("Bill");
        Person person2 = new Person();
        person2.setName("John");
        return Arrays.asList(person, person2);
    }

    @GetMapping("/statusTest")
    public void statusTest(HttpServletResponse response){
        //you can manipulate the response
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
}
