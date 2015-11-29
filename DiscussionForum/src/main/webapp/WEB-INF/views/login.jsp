<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<form:form method="Post" action="postlogin" modelAttribute="userCredential" >

<table>
<tr>
<td>First Name:<FONT color="red">
<%-- <form:errors path="firstName" /> --%></FONT></td>

</tr>
<tr>
<td> <form:input path="userName" />
<!-- <input name='userName' type="text"> -->
</td>
</tr>

<tr>
<td>Password:<FONT color="red">
<%-- <form:errors path="firstName" /> --%></FONT></td>

</tr>
<tr>
<td> <form:password path="password" /> 
<!-- <input name='password' type="password"> -->
</td>
</tr>

<tr>
<td><input type="submit" value="Submit" /></td>
</tr>

</table>

</form:form>
</body>
</html>