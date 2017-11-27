<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit author</title>
</head>
<body>

<form action='../edit'>
<fieldset>
<legend>Edit author - id: ${author.id }</legend>

<input type="hidden" name='id' value='${author.id }'/>
First name: <input type="text" name='firstname' value='${author.firstName }'/><br />
Last name: <input type='text' name='lastname' value='${author.lastName }'/><br />
<input type="submit" value='Edit author'/>

</fieldset>
</form>

</body>
</html>