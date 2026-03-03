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
        <h1>Sign up for our site!</h1>
        <h2>${message}</h2>
        <form action="Public" method="post">
            <input type="hidden" name="action" value="login">
            <label>UserName: </label>
            <input type="text" name="username">
            <label>Email: </label>
            <input type="text" name="email">
            <label>PassWord: </label>
            <input type="text" name="password">
            <input type="submit" value="login">
        </form>
    </body>
</html>
