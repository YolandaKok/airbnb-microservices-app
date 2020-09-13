package com.yolanda.kokkinou.airbnbservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yolanda.kokkinou.airbnbservice.entities.Unit;
import com.yolanda.kokkinou.airbnbservice.repositories.UnitRepository;
import com.yolanda.kokkinou.airbnbservice.services.UnitService;

import javax.transaction.Transactional;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepository repo;

	@Override
	@Transactional
	public Page<Unit> getAllUnits(Pageable page) {
		return repo.findAll(page);
	}

	@Override
	public Page<Unit> getAllUnitsRegion(Pageable page, String region) {
		return repo.findByRegion(region, page);
	}

	@Override
	public Page<Unit> getAllUnitsTitle(Pageable page, String title) {
		return repo.findByTitle(title, page);
	}

	@Override
	public Page<Unit> getAllUnitsRegionAndTitle(Pageable page, String title, String region) {
		return repo.findByRegionAndTitle(region, title, page);
	}

	@Override
	@Transactional
	public List<Unit> getAllUnits() {
		return repo.findAll();
	}

}
