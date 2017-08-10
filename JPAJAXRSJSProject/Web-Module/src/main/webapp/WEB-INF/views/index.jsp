<%-- 
    Document   : index
    Created on : Aug 10, 2017, 11:25:55 AM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Categories</h1>
        <c:forEach var="cat" items="${requestScope.categories}">
        <li>${cat.name}</li>
        </c:forEach>
    </body>
</html>
