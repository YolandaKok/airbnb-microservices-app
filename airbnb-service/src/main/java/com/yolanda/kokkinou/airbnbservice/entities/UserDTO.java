package com.yolanda.kokkinou.airbnbservice.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class UserDTO {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Review> reviews;
}
