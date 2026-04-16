<%-- 
    Document   : registration
    Created on : Mar 3, 2026, 1:26:28 PM
    Author     : mm725161
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <%@include file="/nav.jsp" %>
        <h1>Register for our site!</h1>
        <ul>
            <c:forEach items="${errors}" var="error">
                <li>${error}</li>
            </c:forEach>
        </ul>
        <form action="Public" method="post" class="register">
            <input type="hidden" name="action" value="register">
            <label>Username: </label>
            <input type="text" name="username" value="${username}">
            <br>
            <label>Email: </label>
            <input type="text" name="email" value="${email}">
            <br>
            <label>Password: </label>
            <input type="text" name="password" value="${password}">
            <br>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
