package com.yolanda.kokkinou.airbnbservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yolanda.kokkinou.airbnbservice.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
