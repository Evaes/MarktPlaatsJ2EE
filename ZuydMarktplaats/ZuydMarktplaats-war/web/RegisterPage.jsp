<%-- 
    Document   : RegisterPage
    Created on : Jul 4, 2013, 5:54:46 PM
    Author     : Benji
--%>

<div id="middle">
    <div id="middle-left">
        <a href="administrator.jsp">Administrator</a><br>
        <a href="login">Login</a>
    </div>
    <div id="middle-right">
        <form action="RegistreerActie" method="POST">
            Gebruikersnaam: <input type="text" name="UserName" value="" /><br><br>
            Wachtwoord: <input type="password" name="Password" value="" /><br><br>
            Herhaal wachtwoord: <input type="password" name="Password2" value="" /><br><br>
            Voornaam: <input type="text" name="Voornaam" value="" /><br><br>
            Achternaam: <input type="text" name="Achternaam" value="" /><br><br>
            E-mail: <input type="email" name="Email" value="" /><br><br>
            Telefoonnummer: <input type="text" name="TelefoonNummer" value="" /><br><br>
            <input type="submit" value="Register" />
        </form>
        <% 
            String PassConfirm = "";
            try {
            String Password = request.getParameter("Password");
            String Password2 = request.getParameter("Password2");
            if (!Password.equals(Password2))
                PassConfirm = "De wachtwoorden moeten gelijk zijn!";
            }
            catch (Exception ex)
            {}
            %>
            <%=PassConfirm%>
    </div>
</div>
