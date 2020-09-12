package com.yolanda.kokkinou.airbnbservice.services;

import com.yolanda.kokkinou.airbnbservice.entities.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService {
    boolean createUser(String username, String password);
}
