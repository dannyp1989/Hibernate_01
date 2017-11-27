<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit book</title>
</head>
<body>

<form action='../edit'>
<fieldset>
<legend>Edit book - id: ${book.id }</legend>

<input type="hidden" name='id' value='${book.id }'/>
Title: <input type="text" name='title' value='${book.title }'/><br />
Description: <input type='text' name='description' value='${book.description }'/><br />
Rating: <input type='number' name='rating' value='${book.rating }'/><br />
Author: 	<select name='author_id'>
	<c:forEach items='${authors }' var='author'>
	<option value='${author.id }'>${author.firstName}</option>
	</c:forEach>
	</select><br />
	Publisher: 	<select name='publisher_id'>
	<c:forEach items='${publishers }' var='publisher'>
	<option value='${publisher.id }'>${publisher.name}</option>
	</c:forEach>
	</select><br />
<input type="submit" value='Edit book'/>

</fieldset>
</form>

</body>
</html>