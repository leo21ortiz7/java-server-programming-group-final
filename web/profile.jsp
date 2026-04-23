<%-- 
    Document   : profile
    Author     : Fred Scott Southeast Community College INFO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form action="Private" method="post">
                <input type="hidden" name="action" value="goToEdit">
                <input type="submit" value="Edit Info">
            </form>

            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                    </c:forEach>
            </ul>
        </div >
        <div class="container"> 
            <form action="Private" method="post">
                <input type="hidden" name="action" value="">

                <textarea name="post" id="post" maxlength="240"></textarea>

                <input type="submit" value="Post">
            </form>
        </div>

        <c:forEach items="${statusid}" var="blogPost">
            <ol>
                <li>${status}</li>
            </ol>
        
            <input type="button" id="deletePost" value="Delete Post">
        </c:forEach>

</body>
</html>
