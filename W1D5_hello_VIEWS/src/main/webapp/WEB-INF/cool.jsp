<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cool</title>
</head>
<body>
	<h1>this is a cool page</h1>
	<p>cool</p>
	<hr />
	
	<ul>
		<c:forEach var="x" items="${names}">
			<li><c:out value="${x }"/></li>
		</c:forEach>
	</ul>
	
	<p>there are ${names.size() } people in the array</p>
	
</body>
</html>