package my.test.project.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.test.project.dto.test6.Person;

public class EvictAndMerge {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		// for (int i = 1; i <= 20; i++) {
		// Person p = new Person();
		// p.setName("Name " + i);
		// p.setLastName("Last_Name " + i);
		// session.save(p);
		// }
		int personId = 1;
		Person ss = session.get(Person.class, personId);
		System.out.println("Get Name from Database:" + ss.getName());

		session.evict(ss);
		ss.setName("25");

		session.flush();

		ss = session.get(Person.class, personId);
		System.out.println("Name after evict:" + ss.getName());

		// merge the object
		session.merge(ss);

		ss.setName("30");
		session.flush();

		ss = session.get(Person.class, personId);
		System.out.println("Name after merge:" + ss.getName());
		session.getTransaction().commit();

		session.close();
		session = factory.openSession();
		session.beginTransaction();
		ss.setName("Naval ");

		session.update(ss);
		session.getTransaction().commit();

		session.close();
		factory.close();
	}
}