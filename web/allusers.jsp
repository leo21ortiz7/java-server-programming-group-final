<%-- 
    Document   : allusers
    Created on : Mar 5, 2026, 1:20:15 PM
    Author     : mm725161
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
        <%@include file="/nav.jsp" %>
        <h1>All Users</h1>
        <Table>
            <tr>
                <td>Username</td>
                <td>Email</td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.getUsername()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            </c:forEach>
        </Table>
        <h2>${message}</h2>
    </body>
</html>
