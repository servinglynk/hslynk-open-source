<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add User page</title>
</head>
<body>
<h1>Add User page</h1>
<p>Here you can add a new strategy.</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/add.html">
<table>
<tbody>
	<tr>
		<td>Frst Name:</td>
		<td><form:input path="firstName" /></td>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td><form:input path="lastName" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Add" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>