<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	page isELIgnored="false"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<th>Login</th>
			<th>Password</th>
			<th>E-mail</th>
			<th>Action</th>
		</tr>
		<c:forEach var="person" items="${people }">
			<tr>
				<td>${person.id }</td>
				<td>${person.login }</td>
				<td>${person.password }</td>
				<td>${person.email }</td>
				<td>
					<form action='<c:url value="/people/remove/${person.id }"/>'>
						<input type="submit" value="delete">
					</form>
					<form action='<c:url value="/people/edit/${person.id }"/>'>
						<input type="submit" value="udpate">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<hr>

	<div>

		<form:form method="POST" modelAttribute="person">
		<fieldset>
		<legend>Add new person</legend>
		<table>
		<tr>
		<td>Login:</td><td><form:input path="login"/></td>
		</tr>
		<tr>
		<td>Password:</td><td><form:input path="password"/></td>
		</tr>
		<tr>
		<td>E-mail:</td><td><form:input path="email"/></td>
		</tr>
		</table>
		<input type="submit" value='Add'>
		</fieldset>
		</form:form>

	</div>

	<hr>
	<h1>
		<a href='<c:url value="/"/>'>Go back!</a>
	</h1>
</body>
</html>