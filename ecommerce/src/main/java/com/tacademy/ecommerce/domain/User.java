package com.tacademy.ecommerce.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "t_user")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = { "orders" })
public class User extends AbstractEntity<Long> {

  private static final long serialVersionUID = -4427406588176074887L;

  @Id
  @GeneratedValue
  private Long id;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<Role>();

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

  @Column(length = 12)
  private String mobile;

  public Set<GrantedAuthority> getAuthorities() {
    Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
    this.roles.forEach(role -> authorities.add(role));
    return authorities;
  }

}
