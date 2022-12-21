package com.example.demo3.service;


import com.example.demo3.entity.Role;
import com.example.demo3.entity.User;
import com.example.demo3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findBySupervisor(User user) {
        return userRepository.findBySupervisor(user);
    }

    @Override
    public Double getMaxContractValue(User user) {
        var roles = user.getRoles();
        Double max = roles.stream()
                .map(Role::getMaxContractValue)
                .filter(role -> role >= 0.00)
                .max(Double::compare)
                .orElse(0.00);
        return max;
    }
}