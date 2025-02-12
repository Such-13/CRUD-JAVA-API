package com.dbapi.db_crud_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbapi.db_crud_api.entity.User;
import com.dbapi.db_crud_api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {  // Changed isEmpty() to !isPresent()
            throw new RuntimeException("User not found");
        }

        return user.get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        Optional<User> dbUser = userRepository.findById(user.getId());

        if (!dbUser.isPresent()) {  // Changed isEmpty() to !isPresent()
            throw new RuntimeException("User not found");
        }

        User existingUser = dbUser.get();
        existingUser.setUsername(user.getUsername());

        return userRepository.save(existingUser);
    }

    public void deleteUser(int id) {
        Optional<User> dbUser = userRepository.findById(id);

        if (!dbUser.isPresent()) {  // Changed isEmpty() to !isPresent()
            throw new RuntimeException("User not found");
        }

        userRepository.delete(dbUser.get());
    }
}
