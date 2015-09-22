package com.tacademy.ecommerce.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_user")
@Getter
@Setter
@ToString(exclude = { "orders", "cart" })
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Cart cart;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@OrderBy("orderDate desc")
	private Set<Order> orders = new HashSet<Order>();

	@Column(length = 30)
	private String name;

	@Column(length = 50)
	private String username;

	@Column(length = 255)
	private String password;

	@Column(length = 100)
	private String email;

	@Column(length = 20)
	private String mobile;

}
