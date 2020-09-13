package com.yolanda.kokkinou.airbnbservice.endpoints;

import com.yolanda.kokkinou.airbnbservice.services.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yolanda.kokkinou.airbnbservice.entities.Unit;

import java.util.Optional;

@RestController
@RequestMapping("/api/units")
public class UnitApi {

	private static final Logger logger = LoggerFactory.getLogger(UnitApi.class);

	@Autowired
	private UnitService service;

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	Page<Unit> getAll(@PageableDefault(sort="score", direction=Sort.Direction.DESC) Pageable page,
					  @RequestParam(required=false) Optional<String> title,
					  @RequestParam(required=false) Optional<String> region) {

		if(title.isPresent() && region.isPresent()) {
			return service.getAllUnitsRegionAndTitle(page, title.get(), region.get());
		}

		if(title.isPresent()) {
			logger.info("Title " + title.get());
			return service.getAllUnitsTitle(page, title.get());
		}

		if(region.isPresent()) {
			return service.getAllUnitsRegion(page, region.get());
		}
		return service.getAllUnits(page);
	}

}
