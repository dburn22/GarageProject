<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Garage</title>
<link rel="stylesheet" type="text/css" href="cars.css">
</head>
<div class="garageIntro">
	<body>
	<button class="button"><a href="index.html">Main Menu</a></button>

		<h3>Garage:</h3>
		<c:forEach items="${carList}" var="cars">
			<form action="GetCarData.do" method="GET">
				<div id="div1">
					<ul>
						<li>${cars.carNum}</li>
						<li>${cars.make}</li>
						<li>${cars.model}</li>
						<li>${cars.whp}</li>
						<li>${cars.topSpeed}</li>
						<li>${cars.color}</li>
						</ul>
				</div>
				<div id="carPic">
					<img src="photo/${cars.picture}">
				</div>
				
			</form>
		</c:forEach>
<button class="button"><a href="index.html">Main Menu</a></button>
</div>

</body>
</html>