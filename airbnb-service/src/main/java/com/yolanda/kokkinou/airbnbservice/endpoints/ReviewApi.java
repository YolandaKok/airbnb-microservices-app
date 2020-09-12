package com.yolanda.kokkinou.airbnbservice.endpoints;

import com.yolanda.kokkinou.airbnbservice.dto.ReviewDto;
import com.yolanda.kokkinou.airbnbservice.entities.Review;
import com.yolanda.kokkinou.airbnbservice.exceptions.ApiException;
import com.yolanda.kokkinou.airbnbservice.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/reviews")
public class ReviewApi {
    @Autowired
    private ReviewService service;

    @GetMapping
    public List<Review> getAll() {
        return service.getAllReviews();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public void create(@RequestBody ReviewDto review) {
        if(review.getScore() < 0)
            throw new ApiException("SCORE_LESS_THAN_ZERO_STARS");
        if(review.getScore() > 5)
            throw new ApiException("SCORE_GREATER_THAN_FIVE_STARS");
        service.create(review);
    }
}
