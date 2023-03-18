package com.example.l2p2wiringautowiringqualifier;

import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class L2p2WiringAutowiringQualifierApplication {

    public static void main(String[] args) {
        SpringApplication.run(L2p2WiringAutowiringQualifierApplication.class, args);

        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            Cat cat = context.getBean(Cat.class);
            Owner owner = context.getBean(Owner.class);

            cat.setName("Leo");

            System.out.println(cat);
            System.out.println(owner);
        }
    }

}
