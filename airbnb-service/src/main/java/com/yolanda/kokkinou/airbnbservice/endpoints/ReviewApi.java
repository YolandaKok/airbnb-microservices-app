package com.yolanda.kokkinou.airbnbservice.endpoints;

import com.yolanda.kokkinou.airbnbservice.entities.Review;
import com.yolanda.kokkinou.airbnbservice.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewApi {
    @Autowired
    private ReviewService service;

    @GetMapping
    public List<Review> getAll() {
        return service.getAllReviews();
    }
}
