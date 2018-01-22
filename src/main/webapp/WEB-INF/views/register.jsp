<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Blog</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>

	<body>

		<div class="container">
	
			<form:form name="user" modelAttribute="user" method="post" >
				<h2 class="form-signin-heading">Registro de usuarios</h2>
				
				<form:input path="username" type="text" id="username" cssClass="form-control" placeholder="Nombre de usuario" />
				<label for="password" class="sr-only">Password</label> 
				<form:input path="password" type="password" id="password" cssClass="form-control" placeholder="Contraseña" />
				<label for="passwordverification" class="sr-only">Password</label> 
				<form:input path="passwordverification" type="password" id="passwordverification" cssClass="form-control" placeholder="Contraseña" />
				<label for="email" class="sr-only">Password</label> 
				<form:input path="email" type="email" id="email" cssClass="form-control" placeholder="Email" />
				<button class="btn btn-lg btn-primary btn-block" type="submit">Registro</button>
				
				<form:errors path="*" cssClass="error" />
				
			</form:form>
	
		</div>

	    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>