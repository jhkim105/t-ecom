package demo.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPAQuery;

import demo.DemoJpaApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoJpaApplication.class)
public class QueryDSLTest extends AbstractTransactionalJUnit4SpringContextTests  {

	Log log = LogFactory.getLog(QueryDSLTest.class);

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testGetUserList() {
		QUser user = QUser.user;

		JPAQuery query = new JPAQuery(em);
		query.from(user).where(user.username.eq("jihwan"));
		List<User> resultList = query.list(user);
		log.debug(resultList);
	}

	@Test
	public void testGetUserListWithPagination() {
		QUser user = QUser.user;

		JPAQuery query = new JPAQuery(em);
		query.from(user).where(user.username.eq("jihwan"));
		query.offset(10).limit(20);
		SearchResults<User>	result = query.listResults(user);
		long total = result.getTotal();
		List<User> resultList = result.getResults();
	}

	@Test
	public void testGroupBy() {
		QOrderProduct orderProduct = QOrderProduct.orderProduct;
		JPAQuery query = new JPAQuery(em);
		List<OrderProduct> resultList = query.from(orderProduct).groupBy(orderProduct.order).having(orderProduct.orderAmount.gt(10)).list(orderProduct);
	}

	@Test
	public void testJoin() {
		QOrder order = QOrder.order;
		QUser user = QUser.user;
		QOrderProduct orderProduct = QOrderProduct.orderProduct;

		JPAQuery query = new JPAQuery(em);
		query.from(order)
			.join(order.user, user)
			.leftJoin(order.orderProducts, orderProduct)
			.list(order);
	}

	@Test
	public void testJoinWithOn() {
		QOrder order = QOrder.order;
		QUser user = QUser.user;
		QOrderProduct orderProduct = QOrderProduct.orderProduct;

		JPAQuery query = new JPAQuery(em);
		query.from(order)
			.innerJoin(order.user, user)
			.leftJoin(order.orderProducts, orderProduct)
			.on(orderProduct.orderAmount.gt(2))
			.list(order);
	}

	@Test
	public void testJoinWithFetch() {
		QOrder order = QOrder.order;
		QUser user = QUser.user;
		QOrderProduct orderProduct = QOrderProduct.orderProduct;

		JPAQuery query = new JPAQuery(em);
		query.from(order)
			.innerJoin(order.user, user).fetch()
			.leftJoin(order.orderProducts, orderProduct).fetch()
			.list(order);
	}
}
