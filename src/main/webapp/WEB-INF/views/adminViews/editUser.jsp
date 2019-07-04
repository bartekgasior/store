<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" /> 
		<title>Insert title here</title>
	</head>
	<body>
		<div class = "container">
			<div class = "row">
				<div class = "col-md-4 col-md-offset-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<label> <b>Register</b> </label>
						</div>
						<div class="panel-body">
						
							<form:form class="form-group" modelAttribute="user" method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<fieldset>
									<div>
										<label><b>Username</b></label></br>
										<form:input id="username" placeholder="Username" path="username" type="text" />
										<form:errors path="username" cssClass="text-danger"></form:errors>
									</div>
									<div>
										<label><b>Password</b></label></br>
										<form:input id="password" placeholder="Password" path="password" type="text" />
										<form:errors path="password" cssClass="text-danger"></form:errors>
									</div>
									<div>		
										<label><b>Name</b></label></br>
										<form:input id="name" placeholder="Name" path="name" type="text" />
										<form:errors path="name" cssClass="text-danger"></form:errors>
									</div>
									<div>	
										<label><b>LastName</b></label></br>
										<form:input id="lastName" placeholder="Lastname" path="lastName" type="text" />
									<form:errors path="lastName" cssClass="text-danger"></form:errors>
									</div>
									<div>		
										<label><b>Email</b></label></br>
										<form:input id="email" placeholder="Email" path="email" type="text" />
										<form:errors path="email" cssClass="text-danger"></form:errors>
									</div>
										<input type="submit" class="btn btn-primary" value="Edytuj" />
								</fieldset>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>