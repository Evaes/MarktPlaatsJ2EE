<%-- 
    Document   : overzicht_advs_user
    Created on : 24-jun-2013, 20:00:40
    Author     : Erwin
--%>

<body>
    <div id="middle">
        <div id="middle-left">
            <a href="uitloggen">Uitloggen</a><br>
            <a href="advertenties">Advertenties</a><br>
            <a href="usr_advertenties">Eigen advertenties</a>
        </div>
        <div id="middle-right">
            <table>
                <c:set var="user" value="${user}"/>
                <table>
                    <c:forEach var="columnName" items="${advertenties}">
                        <tr>
                            <td><c:out value="${columnName.naam}"/></td>
                            <td><c:out value="${columnName.beschrijving}"/></td>
                            <td><c:out value="${columnName.vraagprijs}"/></td>
                            <td><a href="adv_edit?adv_id=${columnName.id}">Edit</a></td>
                            <td><a href="adv_usr_delete?adv_id=${columnName.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>              
            </table>
        </div>
    </div>
</body>
</html>
