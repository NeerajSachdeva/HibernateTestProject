package my.test.project.hibernate.test;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.test.project.dto.test1.Address;
import my.test.project.dto.test1.TestDB;
import my.test.project.dto.test1.UserDetails;

public class HibernateTest1 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();

			// #BEGIN TRANSACTION
			session.beginTransaction(); // to define single unit of work.

			// CREATE
			UserDetails user = createUserObject("First");
			session.save(user);

			// CREATE with Embeddable object
			UserDetails user2 = createUserObject("Second");
			user2.setAddress(new Address("street", "city", "state", "pincode"));
			user2.setHomeAddress(new Address("home_street", "homecity", "homestate", "homepincode"));
			session.save(user2);
			session.save(createTestObject());

			// #COMMIT TRANSACTION
			session.getTransaction().commit();

			// READ
			user = session.get(UserDetails.class, 1); // no need to mention PK name
			System.out.println("Read operation" + user.getUserName());
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			/* if you dont close the session, you will see that the server is still runnning. */
			session.close();
			sessionFactory.close();

		}
	}

	private static UserDetails createUserObject(String name) {
		UserDetails user = new UserDetails();
		// user.setUserId(1);
		user.setUserName(name);
		user.setCreateDate(new Date());
		user.setUpdateDate(Calendar.getInstance());

		return user;
	}

	private static TestDB createTestObject() {
		TestDB testDB = new TestDB();
		testDB.setCreatedate(new Date());
		testDB.setDescription("aaaa"
		/* "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" */);
		testDB.setId(1);
		return testDB;
	}
}
