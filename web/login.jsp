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
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <%@include file="/nav.jsp" %>
        <h1>Login To Our Site</h1>
<!--        <h2></h2>-->
        <form action="Public" method="post" class="login">
            <input type="hidden" name="action" value="login">
            <div class="input_container">
                <label>Username: </label>
                <input type="text" name="username">
            </div>
            <div class="input_container">
                <label>Password: </label>
                <input type="text" name="password">
            </div>
            <div class="errors">
                ${message}
            </div>
            <input type="submit" value="login">
        </form>
        <br>
        <form action="Public" method="post">
            <input type="hidden" name="action" value="goToRegister">
            <input type="submit" value="Register New User">
        </form>
    </body>
</html>
