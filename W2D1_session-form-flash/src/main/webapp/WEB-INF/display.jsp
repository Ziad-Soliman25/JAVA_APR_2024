<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<h1>DISPLAY</h1>
	<a href="/">home</a>
	<hr />
	
	your form data is here: <br />
	name: ${ name } <br />
	age: ${ age } <br />
	hidden product id: ${ productId }
	<hr />
	<c:if test="${ age gt 100 }">
		<h4>you are very wise!!!</h4>
	</c:if>
</body>
</html>