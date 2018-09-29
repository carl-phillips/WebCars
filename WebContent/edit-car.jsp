<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editCarsServlet" method="post">
Make: <input type = "text" name = "make" value="${carToEdit.make}">
Model: <input type = "text" name = "model" value="${carToEdit.model}">
Year: <input type = "text" name = "year" value="${carToEdit.year}">
<input type = "hidden" name = "id" value="${carToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>