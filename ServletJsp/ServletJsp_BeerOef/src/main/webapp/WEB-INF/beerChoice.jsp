<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beer choice</title>
</head>
<body>
	<h1 align="center">Select a beer</h1>
	<form action="BeerSelect" method="POST">
	select beer characteristics
	Color: <select name="color">
	<c:forEach var="aColor" items="${beerColors }">
		<option>${aColor}</option>
	</c:forEach>
	</select>
	<br><br>
	<div style="text-align: center;">
		<input type="submit" value="submit">
	</div>
	
	</form>
</body>
</html>