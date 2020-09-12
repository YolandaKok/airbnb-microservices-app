package com.yolanda.kokkinou.airbnbservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yolanda.kokkinou.airbnbservice.entities.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {
    UserDTO findByUsername(String username);
}
