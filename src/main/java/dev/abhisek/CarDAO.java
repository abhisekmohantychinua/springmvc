package dev.abhisek;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAO {
	private final Session session;
	private final Transaction transaction;

	public CarDAO() {
		super();
		SessionFactory sessionFactory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
		this.session = sessionFactory.openSession();
		this.transaction = session.beginTransaction();
	}

	public Car addCar(Car car) {
		session.persist(car);
		return car;
	}

	public List<Car> getCars() {
		List<Car> cars = session.createQuery("select c from car", Car.class).getResultList();
		return cars;
	}

	public void destroy() {
		System.out.println("Dao destructor called.");
		transaction.commit();
		session.close();
	}

}
