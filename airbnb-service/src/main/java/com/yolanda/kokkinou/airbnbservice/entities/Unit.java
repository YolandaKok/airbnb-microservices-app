package com.yolanda.kokkinou.airbnbservice.entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Unit {
	@Id
	private Long id;
	private String title;
	private String description;
	private String cancelation_policy;
	private Integer score;
	private Blob image;
}
