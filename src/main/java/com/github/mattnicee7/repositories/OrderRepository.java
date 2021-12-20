package com.github.mattnicee7.repositories;

import com.github.mattnicee7.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
