package com.yolanda.kokkinou.airbnbservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Review {
	@Id
	private Long id;
	private String comment;
	private Integer score;
	
	@ManyToOne
	private Unit unit;
	
	@ManyToOne
	private UserDTO user;
}
