package my.test.project.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import my.test.project.dto.test6.Person;

public class HibernateTest7 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// for (int i = 11; i <= 20; i++) {
		// Person p = new Person("FirstNAME " + i, "LASTNAME " + i);
		// session.save(p);
		// }

		// Query<Person> query = session.createQuery("from Person");
		Query<Person> query = session.createQuery("from Person where personId > 5 ");
		// Query query = session.createQuery("from Person where id > 5"); //id &
		// personId both works, don't know how
		query.setFirstResult(2); // start from 2nd index
		query.setMaxResults(3); // fetch only 3 records. used for pagination
		List<Person> list = query.list();
		list.forEach(e -> System.out.println(e.getName()));

		Query query2 = session.createQuery("select avg(personId) from Person");
		Number average = (Number) query2.list().get(0);
		System.out.println("Average: " + average);

		/*
		 * This below to be discussed with team
		 *
		 */
		String hql = "update Person set lastName = ? where personId = ?";

		Query query3 = session.createQuery(hql);
		query3.setString(0, "Sachdeva2");
		query3.setInteger(1, 5);
		query3.executeUpdate();

		Query<Person> query3b = session.createQuery("from Person where id=5");
		List<Person> l = query3b.list();
		l.forEach(e -> System.out.println(e.getName() + " " + e.getLastName()));

		// or you can do it this way as well

		hql = "update Person set name = :name where personId = :id";

		Query query4 = session.createQuery(hql);
		query4.setParameter("name", "Neeraj2");
		query4.setParameter("id", 5);
		query4.executeUpdate();

		Query<Person> query4b = session.createQuery("from Person where id=5");
		List<Person> l2 = query4b.list();
		l2.forEach(e -> System.out.println(e.getName() + " " + e.getLastName()));

		/*
		 * This above to be discussed with team Why there is no impact of 2nd
		 * update I think it's not actually DB again may be as DB has got the
		 * correct result of both queries. So how can we fix FETCH problem here.
		 */

		session.close();
		sessionFactory.close();
	}

}
