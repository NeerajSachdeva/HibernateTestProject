package my.test.project.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.test.project.dto.test2.Address2;
import my.test.project.dto.test2.PhoneNumbers2;
import my.test.project.dto.test2.UserDetailsTwo;

public class HibernateTest2 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();

		// #BEGIN TRANSACTION
		session.beginTransaction(); // to define single unit of work.

		// CREATE with set of address objects & list of phone no.
		UserDetailsTwo user = createUserObject("First");
		user.getAddress().add(new Address2("street", "city", "state", "pincode"));
		user.getAddress().add(new Address2("home_street", "homecity", "homestate", "homepincode"));
		user.getPhoneNumbers().add(new PhoneNumbers2(1234567890));
		user.getPhoneNumbers().add(new PhoneNumbers2(1876543209));

		session.save(user);

		// #COMMIT TRANSACTION
		session.getTransaction().commit();

		// READ
		UserDetailsTwo user2 = session.get(UserDetailsTwo.class, 1);
		System.out.println("Address Count:" + user2.getAddress().size());
		/* if we try access Phone no. when the session is close it will give LazyInitializationException */
		// session.close(); // to get the error, uncomment this line & comment line 41
		System.out.println("Phone Count:" + user2.getPhoneNumbers().size());
		session.close();
		sessionFactory.close();
	}

	private static UserDetailsTwo createUserObject(String name) {
		UserDetailsTwo user = new UserDetailsTwo();
		user.setUserName(name);
		return user;
	}

}
