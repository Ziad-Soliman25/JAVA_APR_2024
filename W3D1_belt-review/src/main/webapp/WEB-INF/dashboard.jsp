<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
	<p>welcome ${userName} with id: ${ userId}</p>
	<a href="/trips">home</a> | 
	<a href="/trips/new">CREATE A TRIP</a>
	<a href="/logout">logout</a>
	<%-- ${tripList } --%>
	
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>Location</th>
				<th>length</th>
				<th>owner</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${tripList }" var="eachTrip">
			<tr>
				<td><c:out value="${eachTrip.id }" /> </td>
				<td>
					<a href="/trips/${eachTrip.id }">${eachTrip.location } </a>
				</td>
				<td>${eachTrip.tripLength }</td>
				<td>${eachTrip.owner.userName }</td>
				<td>
					<c:if test="${eachTrip.owner.id eq userId }"> 
						<a href="/trips/${ eachTrip.id}/edit">edit</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	
	<table class="table table-dark">
		<thead>
			<tr>
				<th>location</th>
				<th>length</th>
				<th>description</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${ownedTrips }" var="eachTrip">
				<tr>
					<td>${eachTrip.location }</td>
					<td>${eachTrip.tripLength }</td>
					<td>
					<fmt:formatDate type = "date" dateStyle = "long"
         				value = "${eachTrip.createdAt}" />	
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
</div>
</body>
</html>