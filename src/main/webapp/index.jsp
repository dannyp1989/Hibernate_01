<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Pick what u want to look at</h2>
<ul>
<li><a href='<c:url value="/books"/>'>Books</a></li>
<li><a href='<c:url value="/publishers"/>'>Publishers</a></li>
<li><a href='<c:url value="/authors"/>'>Authors</a></li>
<li><a href='<c:url value="/people"/>'>People</a></li>
<li><a href='<c:url value="/peopledet"/>'>People details</a></li>
</ul>
</body>
</html>
