package com.example.userapi.service;

import com.example.userapi.entity.User;
import com.example.userapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User update(Long id, User user) {

        User existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setAge(user.getAge());
        existing.setPhone(user.getPhone());
        existing.setAddress(user.getAddress());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}