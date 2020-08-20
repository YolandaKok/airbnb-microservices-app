package com.yolanda.kokkinou.airbnbservice.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDTO {
	@Id
	private Long id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;
}
