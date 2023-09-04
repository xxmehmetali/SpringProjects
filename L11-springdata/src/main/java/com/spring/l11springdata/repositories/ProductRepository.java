package com.spring.l11springdata.repositories;

import com.spring.l11springdata.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository annotation is not needed.
//extending JpaRepository is enough because it has @NoRepositoryBean
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //same output following 2:
    Product findProductByName(String name);
    Product findByName(String name);

    @Query("SELECT p FROM Product AS p WHERE p.name=:name")
    Product findProductByNameCustom(String name);
}
