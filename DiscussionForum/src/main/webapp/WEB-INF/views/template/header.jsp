<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	
	<c:choose>
		<c:when test="${not empty login}">
			<a href="<spring:url value="/register"/>">Sign Up</a>
			<a href="<spring:url value="/login"/>">Login</a>
		</c:when>
		<c:otherwise>
			<a href="<spring:url value="/logout"/>">Log Out</a>
			<a href="<spring:url value="/forum"/>">Home</a>
		</c:otherwise>
	</c:choose>
</body>
</html>