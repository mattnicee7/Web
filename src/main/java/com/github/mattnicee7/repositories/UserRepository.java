package com.github.mattnicee7.repositories;

import com.github.mattnicee7.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
