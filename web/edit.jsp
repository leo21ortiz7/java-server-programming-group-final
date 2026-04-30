<%-- 
    Document   : edit
    Created on : Mar 24, 2026, 1:43:21 PM
    Author     : lo775465
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <div class="container">
            <h1>Edit Your Information</h1>

            <form action="Private" method="post">
                <input type="hidden" name="action" value="edit">
                <label>Email:</label>
                <div class="input_container">
                    <input type="text" name="newEmail" <c:out value="${loggedInUser.email}"/>>
                </div>
                <label>Password:</label>
                <div class="input_container">
                    <input type="text" name="newPassword" <c:out value="${loggedInUser.password}"/>>
                </div>
                <input type="submit" value="Submit">
                
                <input type="hidden" name="action" value="cancel">
                <input type="submit" value="Cancel">
            </form>
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>

    </body>
</html>
