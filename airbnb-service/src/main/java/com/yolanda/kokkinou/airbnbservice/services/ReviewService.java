package com.yolanda.kokkinou.airbnbservice.services;

import com.yolanda.kokkinou.airbnbservice.dto.ReviewDto;
import com.yolanda.kokkinou.airbnbservice.entities.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    void create(ReviewDto reviewDto);
}
