package config;

import beans.Cat;
import beans.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("Tom");
        return cat;
    }

    /**
     * Setting a field that is in the context for an object, you will have 2 options.
     * 1- getting the object as parameter
     * 2- calling the method that the child object is created
     */

    @Bean("owner1-1")
    @Primary
    public Owner owner1() {
        Owner owner = new Owner();
        owner.setCat( cat() ); // Takes cat object from context which is created in ProjectConfig with @Bean annotation.
        return owner;
    }

    // Taken cat object is from context.
    // This way provides you to get object from context on seperate files in case you have more than one configuration classes.
    @Bean("owner1-2")
    public Owner owner2(Cat cat) {
        Owner owner = new Owner();
        owner.setCat( cat );
        return owner;
    }

}
