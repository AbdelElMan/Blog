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
	
			<form name="f" action="<c:url value='j_spring_security_check'/>"method="post" class="form-signin">
				<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
				<c:if test="${param.error != null && SPRING_SECURITY_LAST_EXCEPTION.message == null}">
					<div class="alert alert-danger">
						<p>Usuario o contraseña invalido.</p>
						${SPRING_SECURITY_LAST_EXCEPTION.message}
					</div>
				</c:if>
				<c:if test="${param.expired != null}">
					<div class="alert alert-danger">
						<p>Sesion caducada.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>Desconexión correcta.</p>
					</div>
				</c:if>
				<c:if test="${param.locked != null}">
					<div class="alert alert-success">
						<p>Cuenta del usuario bloqueada.</p>
					</div>
				</c:if>
				<h2 class="form-signin-heading">Iniciar sesión</h2>
				<label for="username" class="sr-only">Username</label> 
				<input type="text" id="username" class="form-control" name="j_username" placeholder="Nombre de usuario" required autofocus>
				<label for="password" class="sr-only">Password</label> 
				<input type="password" id="password" class="form-control" name="j_password" placeholder="Contraseña" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
				<a id="linkBanner" href="<c:url value='/register'/>">Registrarse</a>
			</form>
	
		</div>

	    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>