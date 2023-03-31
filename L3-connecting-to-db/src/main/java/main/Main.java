package main;

import config.ProjectConfig;
import models.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.ProductRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
            ProductRepository productRepository = context.getBean(ProductRepository.class);
//  BU PROJE BİTTİ VİDEODA 2. PROJE OLUŞTURUP DEVAM EDİYOR ONDAN DEVAM ET. LESSON3 40:00
//            -- Adding a test data to db
//            Product product = new Product();
//            product.setName("Beer");
//            product.setPrice(100);
//
//            productRepository.addProduct(product);

            List<Product> products = productRepository.getAll();
            System.out.println(products);
        }catch (Exception e){

        }
    }

}
