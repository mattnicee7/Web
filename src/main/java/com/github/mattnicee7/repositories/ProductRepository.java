package com.github.mattnicee7.repositories;

import com.github.mattnicee7.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
