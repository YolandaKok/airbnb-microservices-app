package com.yolanda.kokkinou.airbnbservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yolanda.kokkinou.airbnbservice.entities.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    Page<Unit> findByRegion(String region, Pageable page);
    Page<Unit> findByTitle(String title, Pageable page);
    Page<Unit> findByRegionAndTitle(String region, String title, Pageable page);
}
