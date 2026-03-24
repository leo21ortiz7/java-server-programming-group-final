<%-- 
    Document   : edit
    Created on : Mar 24, 2026, 1:43:21 PM
    Author     : lo775465
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <h1>Edit Your Information</h1>


        <form>
            <input type="hidden" name="action" value="edit">
            <input type="text" name="newEmail" value="${loggedInUser.email}">
            <input type="text" name="newPassword" value="${loggedInUser.password}">
            
            <form>
                <input type="hidden" name="action" value="cancelEdit">
                <input type="submit" value="Cancel">
            </form>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
