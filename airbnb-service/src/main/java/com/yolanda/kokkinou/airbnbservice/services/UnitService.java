package com.yolanda.kokkinou.airbnbservice.services;

import java.util.List;

import com.yolanda.kokkinou.airbnbservice.entities.Unit;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitService {
	Page<Unit> getAllUnits(Pageable page);
	Page<Unit> getAllUnitsRegion(Pageable page, String region);
	Page<Unit> getAllUnitsTitle(Pageable page, String title);
	Page<Unit> getAllUnitsRegionAndTitle(Pageable page, String title, String region);
	List<Unit> getAllUnits();
}
