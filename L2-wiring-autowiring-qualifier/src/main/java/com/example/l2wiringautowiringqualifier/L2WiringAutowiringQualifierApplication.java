package com.example.l2wiringautowiringqualifier;

import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class L2WiringAutowiringQualifierApplication {

    public static void main(String[] args) {
        SpringApplication.run(L2WiringAutowiringQualifierApplication.class, args);

        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            Cat cat = context.getBean(Cat.class);
            Owner owner = context.getBean("owner1-2", Owner.class);

            cat.setName("Tom Changed"); // This cat is from context, so changing cat object from context will affect also owner.

            System.out.println(cat);
            System.out.println(owner);
        }
    }

}
