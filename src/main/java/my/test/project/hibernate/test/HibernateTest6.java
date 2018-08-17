package my.test.project.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.test.project.dto.test6.Person;

public class HibernateTest6 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		// #BEGIN TRANSACTION
		session.beginTransaction(); // to define single unit of work.
		//
		// for (int i = 1; i <= 20; i++) {
		// Address6 adr = new Address6("hellloo");
		//
		// Person p = new Person("FirstNAME " + i, "LASTNAME " + i);
		// p.getAddresses().add(new Address6("hellloo1"));
		// p.getAddresses().add(new Address6("hellloo2"));
		// p.setAddress6(new Address6("addr3"));
		// session.save(p);
		// }

		// Person person = session.load(Person.class, 5); // READ
		// System.out.println(person.getName());
		// System.out.println(person.getAddress6().getAddrName());
		// System.out.println(person.getAddresses());
		// // session.delete(person); // DELETE
		//

		Person person = session.get(Person.class, 3);
		person.setName("Changed Name");
		person.setName("Naval Name");
		// session.update(person); // UPDATE

		// person = session.find(Person.class, 10);

		/*
		 * See person2 obj This shows not always set or update method acts.
		 * Person person = session.get(Person.class, 5); // READ
		 * person.setName("NICE 5");
		 *
		 * Person person2 = session.get(Person.class, 10); // READ person2 = new
		 * Person("1", "2"); System.out.println(person2.getName());
		 * person2.setName("NICE 111110");
		 */

		// #COMMIT TRANSACTION
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
