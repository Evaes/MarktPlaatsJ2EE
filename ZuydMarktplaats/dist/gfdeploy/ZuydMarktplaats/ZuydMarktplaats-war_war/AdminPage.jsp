<div id="middle">
    <div id="middle-left">
    </div>
    <div id="middle-right">
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

        <hr>

        <h1>Advertenties</h1>
        <table border="1px">
            <tr>
                <th>Naam</th>
                <th>Beschrijving</th>
                <th>Vraagprijs</th>
                <th>Verwijderen</th>
            </tr>
            <c:forEach var="columnName" items="${Advertenties}">
                <tr>
                    <td><c:out value="${columnName.naam}"/></td>
                <td><c:out value="${columnName.beschrijving}"/></td>
                <td><c:out value="${columnName.vraagprijs}"/></td>
                <td><a href="delete_adv.jsp?adv_id=${columnName.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

