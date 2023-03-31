package services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {


    public void hello(String name){
        System.out.println("Hello, " + name + "!");
        //throw new RuntimeException("asd");
    }

    public String hello2(String name){
        String message = "Hello, " + name + "!";
        return message;
    }

    public String hello3(String name){
        String message = "Hello, " + name + "!";
        return message;
    }

    public String hello4(String name){
        String message = "Hello, " + name + "!";
        return message;
    }

}
