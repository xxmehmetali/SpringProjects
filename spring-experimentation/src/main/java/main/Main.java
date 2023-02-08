package main;

import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProjectConfig.class);
            MyBean myBean = applicationContext.getBean(MyBean.class);
            System.out.println(myBean.getText());
        }catch (Exception e){

        }
    }
}
