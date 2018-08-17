package my.test.project.hibernate.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import my.test.project.dto.test7.One;
import my.test.project.dto.test7.Two;

/**
 *
 * @author neerajsachdeva
 *
 */
public class HibernateNPlusOneProblem {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Setup
		// session.save(createOne());

		// Problem: to fetch twoList we have to make two backend calls
		// One getOne = session.get(One.class, 1);
		// getOne.getTwoList().size();

		// Solution: Using Dynamic Entity Graph, we can fetch twoList in single
		// query.
		EntityGraph<One> entityGraph = session.createEntityGraph(One.class);
		entityGraph.addAttributeNodes("twoList");

		Map<String, Object> map = new HashMap<>();
		map.put("javax.persistence.loadgraph", entityGraph);

		One one = session.find(One.class, 1, map);
		one.getTwoList().size();

		// Another solution could be left out join
		// or Eager fetch

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	private static One createOne() {
		One one = new One();
		one.setName("1 mai or 1 tu");

		Two two = new Two();
		two.setName("2 * 1 =2");

		Two two2 = new Two();
		two2.setName("2 * 2 = 4 ");

		one.getTwoList().add(two);
		one.getTwoList().add(two2);
		return one;
	}

}
