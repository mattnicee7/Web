package com.github.mattnicee7.services;

import com.github.mattnicee7.entities.User;
import com.github.mattnicee7.repositories.UserRepository;
import com.github.mattnicee7.resources.exceptions.DatabaseException;
import com.github.mattnicee7.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException exception) {
            throw new DatabaseException(exception.getMessage());
        }
    }

    public User update(Long id, User user) {
        User entity = userRepository.getOne(id);
        updateData(entity, user);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}
