<%-- 
    Document   : payfees
    Created on : 03-Feb-2015, 09:10:35
    Author     : jtony_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pay fees for the club selected</title>
    </head>
    <body>
        <div id="indexCentreColumn">
        Here the member will pay their fees to join the club selected.
        credit card details, etc.. will be collected her for processing :)
        <br>For now, just go ahead and pretend that you have paid.
        <br>
            <form action="joinclub" method="post">
                <input type="hidden"
                    name="clubId"  
                    value="${selectedClub.clubID}">
                <input type="submit"
                    value="I HAVE PAID">
            </form>
        </div>
    </body>
</html>
