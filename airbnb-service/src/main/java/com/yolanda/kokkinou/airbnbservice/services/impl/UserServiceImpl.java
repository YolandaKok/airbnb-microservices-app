package com.yolanda.kokkinou.airbnbservice.services.impl;

import com.yolanda.kokkinou.airbnbservice.entities.UserDTO;
import com.yolanda.kokkinou.airbnbservice.repositories.UserRepository;
import com.yolanda.kokkinou.airbnbservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public boolean createUser(String username, String password) {
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return repo.save(user) != null ? true : false;
    }
}
