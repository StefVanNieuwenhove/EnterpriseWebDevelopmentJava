
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beer result</title>
</head>
<body>
	<h1>Beer result</h1>
	<br>
	<p>Got beer color ${colorBeer}</p>
	<c:forEach var="beer" items="${brands}">
		<br>${beer}
	</c:forEach>
</body>
</html>