<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@	page isELIgnored="false"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books</title>
</head>
<body>
	<table border="1px solid black">
		<tr>
			<th>id</th>
			<th>Title</th>
			<th>Rating</th>
			<th>Description</th>
			<th>Author</th>
			<th>Publisher</th>
			<th>Action</th>
		</tr>
		<c:forEach var="book" items="${books }">
		<tr>
			<td>${book.id }</td>
			<td>${book.title }</td>
			<td>${book.rating }</td>
			<td>${book.description }</td>
			<td>${book.author.firstName }</td>
			<td>${book.publisher.name }</td>
			<td>
				<form action='<c:url value="/books/remove/${book.id }"/>'>
				<input type="submit" value="delete">
				</form>
				<form action='<c:url value="/books/edit/${book.id }"/>'>
				<input type="submit" value="udpate">
				</form>
			</td>
			</tr>
		</c:forEach>
	</table>

	<hr>
	
	<form:form method="POST" modelAttribute="book">
	<fieldset>
	<legend>Add new book</legend>
	<table>
	<tr>
	<td>Title:</td>
	<td>
	<form:input	path="title" />
	</td>
	</tr>
	<tr>
	<td>Rating:</td>
	<td>
	<form:input	path="rating" type="number"/>
	</td>
	</tr>
	<tr>
	<td>Description:</td>
	<td>
	<form:textarea	path="description" />
	</td>
	</tr>
	<tr>
	<td>Author:</td>
	<td>
	<form:select path="author" items="${authors }" itemLabel="firstName" itemValue="id"/>
	</td>
	</tr>
	<tr>
	<td>Publisher:</td>
	<td>
	<form:select path="publisher" items="${publishers }" itemLabel="name" itemValue="id"/>
	</td>
	</tr>
	</table>
	<input type="submit" value="Add">
	</fieldset>
	</form:form>
	<!-- <hr>
	<form action='<c:url value="/books/add"/>'>
	<fieldset>
	<legend>Add new book</legend>
	<table>
	<tr>
	<td>Title:</td>
	<td><input type='text' name='title'></td>
	</tr>
	<tr>
	<td>Description:</td>
	<td><input type='text' name='description'></td>
	</tr>
	<tr>
	<td>Rating:</td>
	<td><input type='number' name='rating'></td>
	</tr>
	
	<tr>
	<td>Author:</td>
	<td>
	<select name='author_id'>
	<c:forEach items='${authors }' var='author'>
	<option value='${author.id }'>${author.firstName}</option>
	</c:forEach>
	</select>
	</td>
	</tr>
	
	<tr>
	<td>Publisher:</td>
	<td>
	<select name='publisher_id'>
	<c:forEach items='${publishers }' var='publisher'>
	<option value='${publisher.id }'>${publisher.name}</option>
	</c:forEach>
	</select>
	</td>
	</tr>
	
	
	
	
	</table>
	<input type="submit" value='Add'>
	</fieldset>
	</form>-->
		<hr>
	<h1><a href='<c:url value="/"/>'>Go back!</a></h1>
</body>
</html>
