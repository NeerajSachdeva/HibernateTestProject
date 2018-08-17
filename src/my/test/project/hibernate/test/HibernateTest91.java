package my.test.project.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import my.test.project.dto.test6.Person;

/**
 * First Level Cache
 * 
 * @author neerajsachdeva
 *
 */
public class HibernateTest91 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/*
		 * for (int i = 1; i <= 10; i++) { Person p = new Person("FirstNAME " + i, "LASTNAME " + i); session.save(p); }
		 */

		Person person1 = session.get(Person.class, 5);

		// No SQL query will be executed for below because of 1st level cache
		Person person2 = session.get(Person.class, 5);
		person2.setLastName("Sachdeva");

		// Still no SQL query will be executed for below because of 1st level cache even though person2 is updated as person2 is what
		// person3 object gets being in same session right now.
		Person person3 = session.get(Person.class, 5);

		transaction.commit();
		session.close();

		Session session2 = sessionFactory.openSession();
		Transaction transaction2 = session2.beginTransaction();

		// Now SQL statement will be executed as this another session
		Person person4 = session2.get(Person.class, 5);

		transaction2.commit();
		session2.close();
		sessionFactory.close();
	}

}
