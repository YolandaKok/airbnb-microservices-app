package com.yolanda.kokkinou.airbnbservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yolanda.kokkinou.airbnbservice.entities.Unit;
import com.yolanda.kokkinou.airbnbservice.repositories.UnitRepository;
import com.yolanda.kokkinou.airbnbservice.services.UnitService;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepository repo;

	@Override
	public Page<Unit> getAllUnits(Pageable page) {
		return repo.findAll(page);
	}

	@Override
	public List<Unit> getAllUnits() {
		return repo.findAll();
	}

}
