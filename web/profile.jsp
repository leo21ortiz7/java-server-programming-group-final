<%-- 
    Document   : profile
    Author     : Fred Scott Southeast Community College INFO
--%>

<%@page import="business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //code to direct users out off of the page if they're not logged in
    User jspUser = (User) request.getSession().getAttribute("loggedInUser");
    if (jspUser == null) {
        response.sendRedirect("Public");
        return;
    }


%>

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
            <h1>Welcome ${loggedInUser.username}</h1>
            <form>
                <input type="hidden" name="action" value="goToEdit">
                <input type="submit" value="Edit Info">
            </form>
        </div>
    </body>
</html>
