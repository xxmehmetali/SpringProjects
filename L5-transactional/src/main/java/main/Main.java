package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

public class Main {
    public static void main(String[] args) throws Exception{
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);) {
            ProductService productService = context.getBean("productService", ProductService.class);
            productService.addOneProduct4();

        }
    }
}
