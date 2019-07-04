<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>  
	<head>  
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> 
		<spring:url value="/resources/css/general.css" var="generalCss" />
	
		<link href="${generalCss}" rel="stylesheet" />
		<title>Admin</title>  
	</head>  
	<body>  
		<section>
			<div class="jumbotron">
				<c:url var="logoutUrl" value ="/j_spring_security_logout" />
					<form action="${logoutUrl}" method="post"> 
						<button type="submit" class="btn btn-danger btn-mini pull-right">Wyloguj się</button> 
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
			</div>
		</section>
		<section>
		<div class = "row">
			<div class = "col-md-3 col-md-offset-4">
				<div class="list-group">
				
					<a href = "<spring:url value = "/admin/users" />" class="list-group-item">Users</a>
					<a href = "#" class="list-group-item list-group-item-action">Products</a>
				</div>
			</div>
		</div>
		</section>
	</body>  
</html>  