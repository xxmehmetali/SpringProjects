package config;

import beans.Cat;
import beans.Dog;
import beans.Owner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

    // Note that there are 2 Dog bean without annotated with @Primary. But @Qualifier provides consumers to call beans with specified name.
    // It is like bean id. You can call it with @Qualifier annotation from somewhere else again.

    @Bean
    @Qualifier("dogAlice")
    public Dog dog1(){
        Dog dog = new Dog();
        dog.setName("dog alice");
        return dog;
    }

    @Bean
    @Qualifier("dogBob")
    public Dog dog2(){
        Dog dog = new Dog();
        dog.setName("dog bob");
        return dog;
    }

}
