package com.yolanda.kokkinou.airbnbservice.endpoints;

import com.yolanda.kokkinou.airbnbservice.entities.Review;
import com.yolanda.kokkinou.airbnbservice.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yolanda.kokkinou.airbnbservice.entities.Unit;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitApi {
	@Autowired
	private UnitService service;

	@GetMapping
	Page<Unit> getAll(Pageable page) {
		return service.getAllUnits(page);
	}

	@GetMapping("/test")
	List<Review> getAll() {
		return service.getAllUnits().get(0).getReviews();
	}
}
