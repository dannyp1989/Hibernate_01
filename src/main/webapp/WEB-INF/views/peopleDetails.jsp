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
			<th>First name</th>
			<th>Last name</th>
			<th>Street</th>
			<th>Street number</th>
			<th>City</th>
			<th>Mailing</th>
			<th>Programming skills</th>
			<th>Hobbies</th>
			<th>Action</th>
		</tr>
		<c:forEach var="person" items="${peopleDet }">
			<tr>
				<td>${person.id }</td>
				<td>${person.firstName }</td>
				<td>${person.lastName }</td>
				<td>${person.street }</td>
				<td>${person.streetNumber }</td>
				<td>${person.city }</td>
				<td>${person.mailing }</td>
				<td>
				<c:forEach var="progr" items="${person.programmingSkills }">
				${progr }<br />
				</c:forEach>
				</td>
				<td>
				<c:forEach var="hobby" items="${person.hobbies }">
				${hobby }<br />
				</c:forEach>
				</td>

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

		<form:form method="POST" modelAttribute="personDet">
		<fieldset>
		<legend>Add new person details</legend>
		<table>
		<tr>
		<td>First name:</td><td><form:input path="firstName"/></td>
		</tr>
		<tr>
		<td>Last name:</td><td><form:input path="lastName"/></td>
		</tr>
		<tr>
		<td>Street:</td><td><form:input path="street"/></td>
		</tr>
		<tr>
		<td>Street number:</td><td><form:input path="streetNumber"/></td>
		</tr>
		<tr>
		<td>City:</td><td><form:input path="city"/></td>
		</tr>
		
		<tr>
		<td>Mailing:</td><td><form:checkbox path="mailing"/></td>
		</tr>
		<tr>
		<td>Programming skills:</td><td><form:checkboxes path="programmingSkills" items="${people }"/></td>
		</tr>
		<tr>
		<td>Hobbies:</td><td><form:select path="hobbies" items="${hobbies }"/></td>
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