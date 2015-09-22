package demo.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.jpa.impl.JPAQuery;

import demo.DemoJpaApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoJpaApplication.class)
public class QueryTest extends AbstractTransactionalJUnit4SpringContextTests  {

	Log log = LogFactory.getLog(QueryTest.class);

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testJPQL() {
		String jpql = "select u from User as u where u.username = :username";
		List<User> resultList = em.createQuery(jpql, User.class).setParameter("username", "jihwan").getResultList();
		log.debug(resultList);
	}

	@Test
	public void testCriteria() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);

		Root<User> u = query.from(User.class);

		CriteriaQuery<User> cq = query.select(u).where(cb.equal(u.get("username"), "jihwan"));
		List<User> resultList = em.createQuery(cq).getResultList();
		log.debug(resultList);
	}

	@Test
	public void testQueryDSL() {
		QUser user = QUser.user;

		JPAQuery query = new JPAQuery(em);
		query.from(user).where(user.username.eq("jihwan"));
		List<User> resultList = query.list(user);
		log.debug(resultList);
	}
}
