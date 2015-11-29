<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="Post" action="signup"  modelAttribute="user">

<table>
<tr>
<td>First Name:<FONT color="red">
<%-- <form:errors path="firstName" /> --%></FONT></td>

</tr>
<tr>
<td><form:input path="firstName" /></td>
</tr>
<tr>

<tr>
<td>Last Name:<FONT color="red">
<%-- <form:errors path="firstName" /> --%></FONT></td>

</tr>
<tr>
<td><form:input path="lastName" /></td>
</tr>
<tr>

<tr>
<td>User Name:<FONT color="red">
<%-- <form:errors path="firstName" /> --%></FONT></td>

</tr>
<tr>
<td><form:input path="userCredentials.userName" /></td>
</tr>
<tr>

<td>Password:<FONT color="red"><%-- <form:errors

path="password" /> --%></FONT></td>

</tr>

<tr>

<td><form:password path="userCredentials.password" /></td>

</tr>

<tr>
<td>Email:<FONT color="red"><%-- <form:errors path="email" /> --%></FONT></td>
</tr>

<tr>
<td><form:input path="email" /></td>
</tr>

<tr>
<td><input type="submit" value="Submit" /></td>
</tr>

</table>
</form:form>

</body>
</html>