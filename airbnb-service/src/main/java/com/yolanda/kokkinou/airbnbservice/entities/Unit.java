package com.yolanda.kokkinou.airbnbservice.entities;

import java.sql.Blob;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Unit {
	@Id
	@GeneratedValue
	@Column(name = "unit_id")
	private Long id;
	private String title;
	private String description;
	private String cancelation_policy;
	private Integer score;
	private Blob image;
	private String region;
	
	@OneToMany(mappedBy = "unit", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Review> reviews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCancelation_policy() {
		return cancelation_policy;
	}

	public void setCancelation_policy(String cancelation_policy) {
		this.cancelation_policy = cancelation_policy;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
}
