package com.yolanda.kokkinou.airbnbservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yolanda.kokkinou.airbnbservice.entities.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

}
