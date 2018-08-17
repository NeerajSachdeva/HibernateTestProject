package my.test.project.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.test.project.dto.test4.FourWheeler;
import my.test.project.dto.test4.TwoWheeler;
import my.test.project.dto.test4.Vehicle4;

public class HibernateTest4 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		// #BEGIN TRANSACTION
		session.beginTransaction(); // to define single unit of work.

		Vehicle4 vehicle = new Vehicle4();
		vehicle.setVehicleName("Common any vehicle");

		TwoWheeler bike = new TwoWheeler();
		bike.setSteeringHandle("Bike Handle");
		bike.setVehicleName("Intruder");

		FourWheeler truck = new FourWheeler();
		truck.setSteeringWheel("Truck Steering");
		truck.setVehicleName("Camaro");

		session.save(vehicle);
		session.save(bike);
		session.save(truck);

		// #COMMIT TRANSACTION
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
