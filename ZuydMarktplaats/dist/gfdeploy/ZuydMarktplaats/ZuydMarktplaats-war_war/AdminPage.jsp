<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : test
    Created on : 20-jun-2013, 11:02:18
    Author     : Erwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gebruikers</h1>

        <table border="1px">
            <tr>
                <th>Voornaam</th>
                <th>Achternaam</th>
                <th>Telefoonnummer</th>
                <th>Emailadres</th>
                <th>Username</th>
                <th>Verwijderen</th>
            </tr>
            <c:forEach var="columnName" items="${Users}">
                <tr>
                    <td><c:out value="${columnName.voornaam}"/></td>
                    <td><c:out value="${columnName.achternaam}"/></td>
                    <td><c:out value="${columnName.telefoonnummer}"/></td>
                    <td><c:out value="${columnName.email}"/></td>               
                    <td><c:out value="${columnName.username}"/></td>
                    <td><a href="delete_user.jsp?user_id=${columnName.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
