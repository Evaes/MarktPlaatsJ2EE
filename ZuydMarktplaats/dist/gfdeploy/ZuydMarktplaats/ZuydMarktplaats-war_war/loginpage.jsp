<%-- 
    Document   : loginpage
    Created on : Jun 26, 2013, 3:02:29 PM
    Author     : Benji
--%>

<div id="middle">
    <div id="middle-left">
        <a href="administrator.jsp">Administrator</a><br>
        <a href="login">Login</a>
    </div>
    <div id="middle-right">
        <form action="LoginActie" method="POST">
            Gebruikersnaam: <input type="text" name="UserName" value="" /><br><br>
            Wachtwoord: <input type="password" name="Password" value="" /><br><br>
            <input type="submit" value="Login" />
        </form>
    </div>
</div>