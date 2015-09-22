package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
