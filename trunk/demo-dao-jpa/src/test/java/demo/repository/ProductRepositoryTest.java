package demo.repository;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.DemoDaoJpaApplication;
import demo.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoDaoJpaApplication.class)
public class ProductRepositoryTest {
	@Autowired
	ProductRepository repository;

	@Autowired
	Environment env;

	Log log = LogFactory.getLog(ProductRepositoryTest.class);

	@Test
	public void testFindAll() {
		List<Product> products = repository.findAll();
		assertThat(products.size(), greaterThan(1));
	}

}
