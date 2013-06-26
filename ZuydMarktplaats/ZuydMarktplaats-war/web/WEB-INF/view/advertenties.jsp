<%-- 
    Document   : advertenties
    Created on : 26-jun-2013, 17:35:25
    Author     : Erwin
--%>

<div id="middle">
    <div id="middle-left">
        <a href="administrator.jsp">Administrator</a><br>
        <a href="uitloggen">Uitloggen</a>
    </div>
    <div id="middle-right">
        <table border="1">
            <c:set var="user" value="${user}"/>
            Hallo ${user.voornaam} ${user.achternaam} 

            <table>
                <c:forEach var="columnName" items="${advertenties}">
                    <tr>
                        <td><c:out value="${columnName.naam}"/></td>
                        <td><c:out value="${columnName.beschrijving}"/></td>
                        <td><c:out value="${columnName.vraagprijs}"/></td>
                        
                    </tr>
                </c:forEach>
            </table>
        </table>
    </div>
</div>