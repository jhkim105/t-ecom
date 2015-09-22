package demo.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	private static final Log log = LogFactory.getLog(ProductController.class);
	@RequestMapping("/product/{id}")
	public Product get(@PathVariable Long id) {
		String methodName = "get";
		log.info(String.format("[API]%s START. request:id=%s", methodName, id));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Product product = getProduct();
		
		stopWatch.stop();
		log.info(String.format("[API]%s elasped time:%s secs", methodName,  stopWatch.getTotalTimeSeconds()));
		log.info(String.format("[API]%s END. response:%s", methodName,  product));
		
		return product;
	}

	private Product getProduct() {
		Product product = new Product();
		product.setId(1L);
		product.setName("상품명");
		product.setPrice(125.0D);
		return product;
	}

}
