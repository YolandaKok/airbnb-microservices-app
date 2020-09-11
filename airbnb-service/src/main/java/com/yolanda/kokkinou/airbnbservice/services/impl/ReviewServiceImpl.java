package com.yolanda.kokkinou.airbnbservice.services.impl;

import com.yolanda.kokkinou.airbnbservice.entities.Review;
import com.yolanda.kokkinou.airbnbservice.repositories.ReviewRepository;
import com.yolanda.kokkinou.airbnbservice.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository repo;

    @Override
    @Transactional
    public List<Review> getAllReviews() {
        return repo.findAll();
    }
}
