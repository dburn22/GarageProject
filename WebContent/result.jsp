<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to David's Garage.</title>
<link rel="stylesheet" type="text/css" href="cars.css">
</head>
<body>
	<div id="div1">
		<c:choose>
			<c:when test="${! empty currentList}">
				<ul>
					<li>${currentList[index].carNum}</li>
					<li>${currentList[index].make}</li>
					<li>${currentList[index].model}</li>
					<li>${currentList[index].whp}</li>
					<li>${currentList[index].topSpeed}</li>
					<li>${currentList[index].color}</li>
					<div row=col md 6 id="carPic">
						<li><img src="photo/${currentList[index].picture}"></a></li>
					</div>
				</ul>
				<form action="GetCarData.do" method="GET">
					<button class="button" name="back" value="${index}">Previous</button>
					<button class="button" name="next" value="${index}">Next</button>
					<button class="button" name="Garage" value="GetCarData.do">Back to the Garage!</button>
				</form>
				</c:when>
	<c:otherwise>
		<p>That vehicle is not located in David's Garage</p>
	</c:otherwise>
	</c:choose>
	</div>
	
</body>
</html>