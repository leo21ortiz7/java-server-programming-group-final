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
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <div class="container">
            <%@include file="/nav.jsp" %>
            <h1>All Users</h1>
            <Table>
                <thead>
                <th>Username</th>
                <th>Email</th>
                </thead>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.value.username}" /></td>
                        <td><c:out value="${user.value.email}" /></td>
                    </tr>
                </c:forEach>
            </Table>
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
