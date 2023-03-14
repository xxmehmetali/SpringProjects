package main;

import beans.Bean1;
import beans.Bean2;
import config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try {
            // by type
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProjectConfig.class);
            Bean1 b1 = applicationContext.getBean(Bean1.class);
            System.out.println("primary : " + b1.getText() + "\n");


            // by name
            Bean1 b2 = applicationContext.getBean("myBean2", Bean1.class);
            System.out.println(b2.getText());

            Bean1 b3 = applicationContext.getBean("myBean1", Bean1.class);
            System.out.println(b3.getText());

            Bean1 b4 = applicationContext.getBean("myBean3", Bean1.class);
            System.out.println(b4.getText());
//    -----------------------------------------------------------------------------------
            Bean2 b2_myBean1 = applicationContext.getBean(Bean2.class);
            System.out.println(b2_myBean1.getText());



        } catch (Exception e) {

        }
    }
}
