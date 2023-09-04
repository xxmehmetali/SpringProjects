package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

public class Main
{
    public static void main( String[] args )
    {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            // 26.dkden devam et
            //https://www.youtube.com/watch?v=O9vrhKlGZbE&list=PLEocw3gLFc8WO_HvFzTWUj2fqa7Y8-yg5&index=12&ab_channel=LaurSpilca
            ProductService productService = context.getBean(ProductService.class);
//            productService.addTenProducts();
            productService.addTenProducts3();
        }
    }
}

