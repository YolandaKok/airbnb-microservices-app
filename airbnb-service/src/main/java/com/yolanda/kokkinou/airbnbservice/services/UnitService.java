package com.yolanda.kokkinou.airbnbservice.services;

import java.util.List;

import com.yolanda.kokkinou.airbnbservice.entities.Unit;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitService {
	Page<Unit> getAllUnits(Pageable page);
	List<Unit> getAllUnits();
}
