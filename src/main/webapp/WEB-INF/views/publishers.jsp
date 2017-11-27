<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Publishers</title>
</head>
<body>
	<table border="1px solid black">
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
		<c:forEach var="pub" items="${publishers }">
		<tr>
			<td>${pub.id }</td>
			<td>${pub.name }</td>
			<td>
				<form action='<c:url value="/publishers/remove/${pub.id }"/>'>
				<input type="submit" value="delete">
				</form>
				<form action='<c:url value="/publishers/edit/${pub.id }"/>'>
				<input type="submit" value="udpate">
				</form>
			</td>
			</tr>
		</c:forEach>
	</table>

	<hr>
	<form action='<c:url value="/publishers/add"/>'>
	<fieldset>
	<legend>Add new publisher</legend>
	<table>
	<tr>
	<td>Name:</td>
	<td><input type='text' name='name'></td>
	</tr>
	</table>
	<input type="submit" value='Add'>
	</fieldset>
	</form>
	
</body>
</html>