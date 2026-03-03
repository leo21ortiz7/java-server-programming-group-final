<%-- 
    Document   : home
    Author     : Fred Scott Southeast Community College INFO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login To Our Site</h1>
        <h2>${message}</h2>
        <form action="Public" method="post">
            <input type="hidden" name="action" value="login">
            <label>UserName: </label>
            <input type="text" name="username">
            <label>PassWord: </label>
            <input type="text" name="password">
            <input type="submit" value="login">
        </form>
    </body>
</html>
