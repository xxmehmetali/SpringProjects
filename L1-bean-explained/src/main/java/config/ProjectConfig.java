package config;

import beans.Bean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @ComponentScan(basePackages = "beans") will find classes annotated with @Component
 * If you do not use @ComponentScan, then Application Context will not see classes annotated with @Component.
 */
@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

    @Bean
    public Bean1 myBean1() {
        Bean1 myBean = new Bean1();
        myBean.setText("My Bean is here ! myBean1");
        myBean.setCount(1);
        return myBean;
    }

    /**
     * @Primary annotation will be helpful when bean is called by type.
     * If you use define 2 same bean types and call by type, then @Primary one will be returned.
     */
    @Bean
    @Primary
    public Bean1 myBean2() {
        Bean1 myBean2 = new Bean1();
        myBean2.setText("My Bean is here ! myBean2");
        myBean2.setCount(10);
        return myBean2;
    }

    /**
     * If you use "name" or "value" in Bean annotation, it will be valid rather than method name.
     * @Bean(name = "myBean3")
     * @Bean(value = "myBean3")
     * are same.
     */
    @Bean("myBean3")
    public Bean1 myBean3(){
        Bean1 myBean3 = new Bean1();
        myBean3.setText("My Bean is here ! myBean3");
        return myBean3;
    }
}
