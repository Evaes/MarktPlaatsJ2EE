<%-- 
    Document   : user_adv_detail
    Created on : 24-jun-2013, 20:44:06
    Author     : Erwin
--%>

<div id="middle">
    <div id="middle-left">
        <a href="uitloggen">Uitloggen</a><br>
        <a href="advertenties">Advertenties</a>
    </div>
    <div id="middle-right">
        <c:set var="a" value="${advertentie}"/>

        <form action="do_edit_adv" method="POST">
            Id: <input type="text" name="id" value="${a.id}" readonly="readonly" /><br>
            Productnaam: <input type="text" name="naam" value="${a.naam}" readonly="readonly"/> <br>
            Beschrijving: <input type="text" name="beschrijving" value="${a.beschrijving}" /><br>
            Vraagprijs: <input type="text" name="vraagprijs" value="${a.vraagprijs}" /><br>
            
            <input type="submit" value="Edit" />
        </form>
    </div>
</div>
