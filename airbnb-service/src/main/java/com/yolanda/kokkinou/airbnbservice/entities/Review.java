package com.yolanda.kokkinou.airbnbservice.entities;

import javax.persistence.*;

@Entity
public class Review {
	@Id
	private Long id;
	private String comment;
	private Integer score;
	
	@ManyToOne
	@JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
	private Unit unit;
	
	@ManyToOne
	private UserDTO user;
}
