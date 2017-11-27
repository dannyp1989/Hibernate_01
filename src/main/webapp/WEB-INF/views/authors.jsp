<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authors</title>
</head>
<body>
	<table border="1px solid black">
		<tr>
			<th>id</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Action</th>
		</tr>
		<c:forEach var="aut" items="${author }">
		<tr>
			<td>${aut.id }</td>
			<td>${aut.firstName }</td>
			<td>${aut.lastName }</td>
			<td>
				<form action='<c:url value="/authors/remove/${aut.id }"/>'>
				<input type="submit" value="delete">
				</form>
				<form action='<c:url value="/authors/edit/${aut.id }"/>'>
				<input type="submit" value="udpate">
				</form>
			</td>
			</tr>
		</c:forEach>
	</table>

	<hr>
	<form action='<c:url value="/authors/add"/>'>
	<fieldset>
	<legend>Add new author</legend>
	<table>
	<tr>
	<td>First name:</td>
	<td><input type='text' name='firstname'></td>
	</tr>
	<tr>
	<td>Last name:</td>
	<td><input type='text' name='lastname'></td>
	</tr>
	</table>
	<input type="submit" value='Add'>
	</fieldset>
	</form>
	
</body>
</html>