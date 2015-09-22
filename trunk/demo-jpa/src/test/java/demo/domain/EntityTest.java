package demo.domain;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.DemoJpaApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoJpaApplication.class)
public class EntityTest extends AbstractTransactionalJUnit4SpringContextTests {

	Log log = LogFactory.getLog(EntityTest.class);

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testSaveUserDetail() {
		User user = new User();
		user.setUsername("username");
		user = em.merge(user);
		log.debug(user);
		UserDetail userDetail = new UserDetail();
		userDetail.setUser(user);
		userDetail = em.merge(userDetail);
		em.flush();
		log.debug(userDetail);
	}

	@Test
	public void testSaveOrder() {
		// User 저장
		User user = new User();
		user.setUsername("user1");
		em.persist(user);

		// Order 저장
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setUser(user); // 연관관계 설정
		user.getOrders().add(order); // 무시:연관관계의 주인이 아님)
		em.persist(order);
	}


}
