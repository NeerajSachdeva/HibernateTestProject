package my.test.project.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.test.project.dto.test5.FourWheeler5;
import my.test.project.dto.test5.TwoWheeler5;
import my.test.project.dto.test5.Vehicle5;

public class HibernateTest5 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		// #BEGIN TRANSACTION
		session.beginTransaction(); // to define single unit of work.

		Vehicle5 vehicle = new Vehicle5();
		vehicle.setVehicleName("Common any vehicle");

		TwoWheeler5 bike = new TwoWheeler5();
		bike.setSteeringHandle("Bike Handle");
		bike.setVehicleName("Intruder");

		FourWheeler5 truck = new FourWheeler5();
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
