package dev.abhisek;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {

	private final CarDAO carDAO;

	public Car addCar(String model, String brand, String price) {
		Car car = Car.builder().id(UUID.randomUUID().toString()).model(model).brand(brand)
				.price(Integer.parseInt(price)).build();
		carDAO.addCar(car);
		return car;
	}

	public List<Car> getCars() {
		return carDAO.getCars();
	}
}
