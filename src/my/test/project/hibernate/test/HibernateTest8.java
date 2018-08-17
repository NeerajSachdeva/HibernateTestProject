package my.test.project.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import my.test.project.dto.test6.Person;

public class HibernateTest8 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// for (int i = 11; i <= 20; i++) {
		// Person p = new Person("FirstNAME " + i, "LASTNAME " + i);
		// session.save(p);
		// }

		Criteria criteria1 = session.createCriteria(Person.class);
		criteria1.add(Restrictions.gt("personId", 1));
		criteria1.add(Restrictions.lt("personId", 10));

		criteria1.setFirstResult(3); // start from 2nd index
		criteria1.setMaxResults(3); // fetch only 3 records. used for pagination

		List<Person> list = criteria1.list();
		list.forEach(e -> System.out.println(e.getName()));

		Criteria criteria2 = session.createCriteria(Person.class);
		list = criteria2.add(Restrictions.or(Restrictions.eq("personId", 2), Restrictions.like("name", "%Neeraj%")))
				.list();

		list.forEach(e -> System.out.println(e.getName()));

		// Query Using Projection
		// Aggregate Function
		Criteria criteria3 = session.createCriteria(Person.class);
		list = criteria3.setProjection(Projections.max("personId")).list();

		System.out.println("MAX: " + list.get(0));

		Criteria criteria4 = session.createCriteria(Person.class);
		list = criteria4.setProjection(Projections.sum("personId")).list();
		System.out.println("Sum: " + list.get(0));

		// Query By Example
		Person examplePerson = new Person("Neeraj%", null);
		Example example = Example.create(examplePerson).enableLike();
		Criteria criteria5 = session.createCriteria(Person.class);
		list = criteria5.list();
		System.out.println("Query by example: " + list.get(0).getName() + " " + list.get(0).getLastName());

		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}

}
