package com.example;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SuppressWarnings("null")
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @SuppressWarnings("null")
    public UserEntity getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public List<UserEntity> findByName(String name) {
        return userRepository.findByName(name);
    }
}
