package com.github.mattnicee7.repositories;

import com.github.mattnicee7.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
