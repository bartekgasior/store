<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />
		<title>Login page</title>
	</head>
	<body>
	
	<div class = "container">
		<div class = "row">
			<div class = "col-md-4 col-md-offset-4 ">
			
			
				<div class = "panel panel-primary">
					
					<div class = "panel-heading"> Login </div>
					<div class = "panel-body"> 
						<c:url var="loginUrl" value ="/login" />
						<form action ="${loginUrl}" method="post" class="form-group">
							<c:if test="${not empty errorMessage}">
                                <div class="alert alert-danger">
                                    <p>${errorMessage}</p>
                                </div>
                            </c:if>
                            <c:if test="${not empty logoutMessage}">
                                <div class="alert alert-info">
                                    <p>${logoutMessage}</p>
                                </div>
                            </c:if>
                            <c:if test="${not empty registeredMessage}">
                                <div class="alert alert-success">
                                    <p>${registeredMessage}</p>
                                </div>
                            </c:if>
                            
                            <c:if test="${not empty usernameMessage}">
                                <div class="alert alert-danger">
                                    <p>${usernameMessage}</p>
                                </div>
                            </c:if>
							<div>
								<label><b>Username:</b></label>
								<input type="text" class="form-control" id="username" name="username" placeholder="Enter username" required autofocus/>
							</div>
							<div>
								<label><b>Password:</b></label>
								<input type="password" class="form-control" id="password" name="password" placeholder="Enter password" value="" required/>
							</div>
							
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							
							<input class="btn btn-success center-block" type="submit" value="Login"/>
							
							<div style="text-align:right;">
								<a href="register" >
									register
								</a>
							</div>
							
						</form>
					</div>
					
				</div>
			
			</div>
		</div>
	</div>
	
	
	</body>
</html>