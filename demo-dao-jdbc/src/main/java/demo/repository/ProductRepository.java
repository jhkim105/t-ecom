package demo.repository;

import java.util.List;

import demo.domain.Product;

public interface ProductRepository {

	List<Product> findAll();

	Product findOne(Long id);

	Product save(Product product);

	void delete(Long id);

	long countAll();
}
