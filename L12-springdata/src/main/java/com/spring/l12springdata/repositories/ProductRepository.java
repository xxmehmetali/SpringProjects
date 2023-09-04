package com.spring.l12springdata.repositories;

import com.spring.l12springdata.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findProductsByName(String name, Pageable p);
}