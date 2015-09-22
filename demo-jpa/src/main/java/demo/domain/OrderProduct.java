package demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "orders_products")
public class OrderProduct {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@MapsId("orderId")
	private Order order;

	@ManyToOne
	@MapsId("productId")
	private Product product;

	private Integer orderAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}


}
