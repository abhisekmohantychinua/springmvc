<%@page import="dev.abhisek.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cars</title>
</head>
<body>

	<h1>Add New Car</h1>
	<form action="/sep1-spring-mvc-hib/addcar">
		<label for="model">Model :</label> <input id="model" type="text"
			name="model" /> <br> <br> <label for="brand">Brand
			:</label> <input id="brand" type="text" name="brand" /> <br> <br>
		<label for="price">Price :</label> <input id="price" type="text"
			name="price" /> <br> <br>
		<button type="submit">Submit</button>
	</form>
	<br>
	<br>
	<br>
	<h1>Cars</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>model</th>
				<th>brand</th>
				<th>price</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Car> cars = (List<Car>) request.getAttribute("cars");
			%>
			<%
			cars.forEach((car) -> {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getModel()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
			<%
			});
			%>

		</tbody>
	</table>

</body>
</html>