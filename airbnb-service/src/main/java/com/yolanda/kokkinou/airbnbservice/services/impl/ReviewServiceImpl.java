package com.yolanda.kokkinou.airbnbservice.services.impl;

import com.yolanda.kokkinou.airbnbservice.dto.ReviewDto;
import com.yolanda.kokkinou.airbnbservice.entities.Review;
import com.yolanda.kokkinou.airbnbservice.entities.Unit;
import com.yolanda.kokkinou.airbnbservice.entities.UserDTO;
import com.yolanda.kokkinou.airbnbservice.enums.ErrorCodes;
import com.yolanda.kokkinou.airbnbservice.exceptions.ApiException;
import com.yolanda.kokkinou.airbnbservice.repositories.ReviewRepository;
import com.yolanda.kokkinou.airbnbservice.repositories.UnitRepository;
import com.yolanda.kokkinou.airbnbservice.repositories.UserRepository;
import com.yolanda.kokkinou.airbnbservice.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UnitRepository unitRepo;

    @Override
    @Transactional
    public List<Review> getAllReviews() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public void create(ReviewDto reviewDto) {
        Review review = new Review();
        Optional<UserDTO> user = userRepo.findById(reviewDto.getUserId());
        if(!user.isPresent()) {
            throw new ApiException(ErrorCodes.USER_NOT_FOUND.toString());
        }
        Optional<Unit> unit = unitRepo.findById(reviewDto.getUnitId());
        if(!unit.isPresent()) {
            throw new ApiException(ErrorCodes.UNIT_NOT_FOUND.toString());
        }
        review.setComment(reviewDto.getComment());
        review.setScore(reviewDto.getScore());
        review.setUser(user.get());
        review.setUnit(unit.get());
        repo.save(review);
    }
}
