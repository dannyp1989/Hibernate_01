<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit publisher</title>
</head>
<body>

<form action='../edit'>
<fieldset>
<legend>Edit publisher - id: ${publisher.id }</legend>

<input type="hidden" name='id' value='${publisher.id }'/>
Name: <input type="text" name='name' value='${publisher.name }'/><br />
<input type="submit" value='Edit publisher'/>

</fieldset>
</form>

</body>
</html>