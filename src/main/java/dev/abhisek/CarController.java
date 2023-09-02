package dev.abhisek;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class CarController {

	private final CarService carService;

	public String getCars(HttpServletRequest request) {
		List<Car> cars = carService.getCars();
		request.setAttribute("cars", cars);
		return "index.jsp";
	}

	@PostMapping
	public String addCar(HttpServletRequest request) {
		String model = request.getParameter("model");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");

		carService.addCar(model, brand, price);

		return "redirect:/index.jsp";
	}
}
