package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //https://www.youtube.com/watch?v=QzyucYRGRlk&list=PLEocw3gLFc8WO_HvFzTWUj2fqa7Y8-yg5&index=18&ab_channel=LaurSpilca
    //35:41 de kaldın
    @Transactional
    public void addTenProducts() {
        for (int i = 0; i < 10; i++) {
            productRepository.addProduct("Product" + String.valueOf(i+1));
        }
    }
}
