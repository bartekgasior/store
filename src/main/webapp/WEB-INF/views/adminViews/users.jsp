<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" /> 
		<title>Edit users</title>
		</head>
	<body>
		<div class = "row">
			<div class = "col-md-4 col-md-offset-4">
				<div class = "form-group">
					<table class = "table table-hover">
						<thead>
							<tr>
								<th>Username</th>
								<th>E-mail</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items = "${users}" var = "user">
								<tr>
									<td>${user.username }</td>
									<td>${user.email }</td>
									<td>
										<a href="<spring:url value = "/admin/users/edit?id=${user.id}" />">
											<span class = "glyphicon glyphicon-edit"> </span> 	
										</a> 
									</td>
									<td>
										<a href = "<spring:url value = "/admin/users/delete/${user.id }" /> ">
											<span class = "glyphicon glyphicon-trash" style="color:red"> </span>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>