package com.yolanda.kokkinou.airbnbservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Review {
	@Id
	private Long id;
	private String comment;
	private Integer score;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
	private Unit unit;

	@JsonIgnore
	@ManyToOne
	private UserDTO user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
