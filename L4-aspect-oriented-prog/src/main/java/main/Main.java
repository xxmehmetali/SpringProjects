package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloService;

public class Main {
    public static void main(String[] args) {
        try {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

            HelloService helloService = context.getBean("helloService", HelloService.class);
            helloService.hello("John");

            System.out.println("----------");

            String result = helloService.hello2("Dany");
            System.out.println(result);

            System.out.println("----------");

            String result2 = helloService.hello3("Ali");
            System.out.println(result2);

            System.out.println("----------");

            String result3 = helloService.hello4("Ali");
            System.out.println(result3);

        } catch (Exception e) {

        }
    }
}
