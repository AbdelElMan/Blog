<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>Blog</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
	    <!-- Custom styles for this template -->
	    <link href="https://blackrockdigital.github.io/startbootstrap-clean-blog/css/clean-blog.min.css" rel="stylesheet">
		
	    <!-- Custom fonts for this template -->
	    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
	    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
			
	</head>

	<body>
		
		<div class="container">
			<div class="row">
			
				<div class="col-lg-8 col-md-10 mx-auto">
						<div class="post-preview">
							<a id="linkBanner" href="<c:url value='/entries/${entry.id}'/>">
							<h2 class="post-title">
								${entry.title}
			              	</h2>
							<h3 class="post-subtitle">
								${entry.content}
							</h3>
							</a>
			            	<p class="post-meta">Creado por <a href="#">${entry.user.username}</a>, <fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${entry.createdOn}" />. <span> ${fn:length(services)} comentarios </span> </p>
			            	<p class="post-meta">
				            	Etiquetas:
				            	<c:forEach items="${entry.tags}" var="tag">
									<span class="badge badge-pill badge-info">${tag.name}</span>
				            	</c:forEach>
			            	</p>
						</div>
				</div>
			
				<div class="col-lg-8 col-md-4 mx-auto">

			        <c:forEach items="${entry.comments}" var="comment">	        	
						<div class="post-preview">
							<h2 class="post-title">
								${comment.title}
			              	</h2>
							<h3 class="post-subtitle">
								${comment.text}
							</h3>
			            	<p class="post-meta">Creado por <a href="#">${comment.user.username}</a>, <fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${comment.createdOn}" /></span> </p>
						</div>
			          	<hr>
					</c:forEach>

					<form:form name="comment" modelAttribute="comment" method="post" >
						<h4 class="form-signin-heading">Añadir comentario</h2>
						
						<label for="title" class="sr-only">Título</label>
						<form:input path="title" type="text" id="title" cssClass="form-control" placeholder="Título" />
						
						<label for="text">Comentario</label>
						<form:textarea path="text" cssClass="form-control" id="text" rows="3"></form:textarea>
										
						<button class="btn btn-lg btn-primary btn-block" type="submit">Añadir comentario</button>
						
						<form:errors path="*" cssClass="error" />
						
					</form:form>

				</div>
			</div>
		</div>

	    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	</body>
</html>