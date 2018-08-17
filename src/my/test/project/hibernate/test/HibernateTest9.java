package my.test.project.hibernate.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import my.test.project.dto.test6.Person;

public class HibernateTest9 {

	public static void main(String[] args) {

		Transaction transaction = null;

		try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.openSession()) {

			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Person> query = builder.createQuery(Person.class);
			Root<Person> root = query.from(Person.class);
			query.select(root);

			Query<Person> q = session.createQuery(query);

			List<Person> employees = q.getResultList();
			// List<Person> employees = q.list(); //same as getResultList
			employees.forEach(e -> System.out.println(e.getName() + " " + e.getLastName()));

			/*
			 *
			 */
			CriteriaQuery<String> query2 = builder.createQuery(String.class);
			Root<Person> root2 = query2.from(Person.class);
			query2.select(root2.get("name"));
			Query<String> q1 = session.createQuery(query2);
			List<String> names = q1.getResultList();
			names.forEach(System.out::println);

			/*
			 *
			 */
			CriteriaQuery<Object[]> query3 = builder.createQuery(Object[].class);
			Root<Person> root3 = query3.from(Person.class);
			query3.multiselect(root3.get("name"), root3.get("lastName"));
			Query<Object[]> q3 = session.createQuery(query3);
			List<Object[]> list = q3.getResultList();
			for (Object[] objects : list) {
				System.out.println("Name : " + objects[0]);
				System.out.println("Last Name : " + objects[1]);
			}

			// Count number of Person
			CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
			Root<Person> root4 = criteriaQuery.from(Person.class);
			criteriaQuery.select(builder.count(root4));
			Query<Long> q4 = session.createQuery(criteriaQuery);
			long count = q4.getSingleResult();
			System.out.println("Count = " + count);

			// Get max id
			CriteriaQuery<Integer> criteriaQuery2 = builder.createQuery(Integer.class);
			Root<Person> root5 = criteriaQuery2.from(Person.class);
			criteriaQuery2.select(builder.max(root5.get("personId")));
			Query<Integer> q5 = session.createQuery(criteriaQuery2);
			int maxSalary = q5.getSingleResult();
			System.out.println("Max Id = " + maxSalary);

			// Get Average
			CriteriaQuery<Double> criteriaQuery3 = builder.createQuery(Double.class);
			Root<Person> root6 = criteriaQuery3.from(Person.class);
			criteriaQuery3.select(builder.avg(root6.get("personId")));
			Query<Double> q6 = session.createQuery(criteriaQuery3);
			double avgSalary = q6.getSingleResult();
			System.out.println("Average = " + avgSalary);

			// Count distinct Person
			CriteriaQuery<Long> criteriaQuery4 = builder.createQuery(Long.class);
			Root<Person> root7 = criteriaQuery4.from(Person.class);
			criteriaQuery4.select(builder.countDistinct(root7));
			Query<Long> q7 = session.createQuery(criteriaQuery4);
			long distinct = q7.getSingleResult();
			System.out.println("Distinct count = " + distinct);

			// Order by Last Name
			CriteriaQuery<Person> criteriaQuery5 = builder.createQuery(Person.class);
			Root<Person> root8 = criteriaQuery5.from(Person.class);
			criteriaQuery5.select(root8);
			criteriaQuery5.orderBy(builder.desc(root8.get("lastName"))); // asc for ascending
			Query<Person> q8 = session.createQuery(criteriaQuery5);
			List<Person> list8 = q8.getResultList();
			for (Person employee : list8) {
				System.out.println("NAME=" + employee.getName() + "\t Last Name=" + employee.getLastName());
			}

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}