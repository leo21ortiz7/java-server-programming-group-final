<%-- 
    Document   : registration
    Created on : Mar 3, 2026, 1:26:28 PM
    Author     : mm725161
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <h1>Register up for our site!</h1>
        <h2>${message}</h2>
        <form action="Public" method="post">
            <input type="hidden" name="action" value="register">
            <label>Username: </label>
            <input type="text" name="username">
            <br>
            <label>Email: </label>
            <input type="text" name="email">
            <br>
            <label>Password: </label>
            <input type="text" name="password">
            <br>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
