package com.yolanda.kokkinou.airbnbservice.endpoints;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yolanda.kokkinou.airbnbservice.entities.Unit;

@RestController
@RequestMapping("/api/units")
public class UnitApi {
	@GetMapping
	Page<Unit> getAll(Pageable pageable, @RequestParam(required=false) Optional<String> title,
            @RequestParam(required=false) Optional<String> region) {
		// Return page		
		return null;
	}
}
