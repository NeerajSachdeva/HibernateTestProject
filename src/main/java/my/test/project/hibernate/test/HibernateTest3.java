package my.test.project.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.test.project.dto.test3.Address3;
import my.test.project.dto.test3.BodyParts;
import my.test.project.dto.test3.Parents;
import my.test.project.dto.test3.PhoneNumbers3;
import my.test.project.dto.test3.UserDetailsThree;
import my.test.project.dto.test3.Vehicle3;

public class HibernateTest3 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		// #BEGIN TRANSACTION
		session.beginTransaction(); // to define single unit of work.

		// CREATE with set of address objects & list of phone no.
		Vehicle3 vehicle = createVehicleObject("Vehicle_ONE");

		UserDetailsThree user = createUserObject("First");
		user.setVehicle(vehicle);
		Address3 address1 = new Address3("street", "city", "state", "pincode");
		Address3 address2 = new Address3("street2", "city2", "state2", "pincode2");
		user.getAddress().add(address1);
		user.getAddress().add(address2);

		PhoneNumbers3 number1 = new PhoneNumbers3(123);
		PhoneNumbers3 number2 = new PhoneNumbers3(456);
		number1.setUserDetailsThree(user);
		number2.setUserDetailsThree(user);
		user.getPhoneNumbers().add(number1);
		user.getPhoneNumbers().add(number2);

		Parents parent1 = new Parents("Parent1");
		Parents parent2 = new Parents("Parent2");
		UserDetailsThree user2 = createUserObject("First");

		parent1.getUsers().add(user);
		parent1.getUsers().add(user2);
		user.getParents().add(parent1);
		user.getParents().add(parent2);

		UserDetailsThree user3 = new UserDetailsThree();
		BodyParts bodyPart1 = new BodyParts("hands");
		BodyParts bodyPart2 = new BodyParts("legs");
		user3.getBodyParts().add(bodyPart1);
		user3.getBodyParts().add(bodyPart2);

		session.save(user);
		session.save(user2);
		session.persist(user3);
		session.save(vehicle);
		session.save(address1);
		session.save(address2);
		session.save(number1);
		session.save(number2);
		session.save(parent1);
		session.save(parent2);

		// #COMMIT TRANSACTION
		session.getTransaction().commit();

		// // READ
		// UserDetailsTwo user2 = session.get(UserDetailsTwo.class, 1);
		// System.out.println("Address Count:" + user2.getAddress().size());
		// /* if we try access Phone no. when the session is close it will give
		// LazyInitializationException */
		// // session.close(); // to get the error, uncomment this line &
		// comment line 41
		// System.out.println("Phone Count:" + user2.getPhoneNumbers().size());
		session.close();
		sessionFactory.close();
	}

	private static Vehicle3 createVehicleObject(String name) {
		Vehicle3 vehicle = new Vehicle3();
		vehicle.setVehicleName(name);
		return vehicle;
	}

	private static UserDetailsThree createUserObject(String name) {
		UserDetailsThree user = new UserDetailsThree();
		user.setUserName(name);
		return user;
	}

}
