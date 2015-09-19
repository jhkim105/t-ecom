package com.tcacademy.ecommerce.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "t_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractEnitty<Long> implements UserDetails {

  private static final long serialVersionUID = -4427406588176074887L;

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "role_id", referencedColumnName = "id")
  protected Role role;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Cart cart;

  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
  @OrderBy("orderDate desc")
  private Set<Order> orders = new HashSet<Order>();

  @Column(length = 30)
  private String name;

  @Column(length = 50)
  private String username;

  @Column(length = 20)
  private String password;

  @Column(length = 100)
  private String email;

  @Column(length = 12)
  private String mobile;

  @Column(name = "account_enabled")
  private boolean enabled;

  @Column(name = "account_expired")
  private boolean accountExpired;

  @Column(name = "account_locked")
  private boolean accountLocked;

  @Column(name = "credentials_expired")
  private boolean credentialsExpired;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
    authorities.add(role);
    return authorities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return !accountExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !accountLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return !credentialsExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

}
