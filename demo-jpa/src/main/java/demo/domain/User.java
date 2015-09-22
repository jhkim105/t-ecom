package demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.steps.uniqueIndexSeekLeafPlanner;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private Set<Order> orders = new HashSet<Order>();

	@OneToOne(mappedBy="user")
	private Membership membership;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
