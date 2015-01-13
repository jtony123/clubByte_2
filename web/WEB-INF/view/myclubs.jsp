<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : myclubs
    Created on : 13-Jan-2015, 15:09:56
    Author     : jtony_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clubs you are a member of</title>
    </head>
    <body>
        <div id="indexLeftColumn">
           Hi!
        </div>        
        <div id="indexCentreColumn">
            Your Clubs 
            <table id="myClubTable">  
                <td>Club Name</td>
                <td>Description</td>
                <td>Club Owner</td>
                <td>Max Members</td>
                <c:forEach var="aclub" items="${myclubs}" varStatus="iter">
                    <tr>
                        <td>
                            ${aclub.club.clubName}
                        </td>    
                        <td>  
                            ${aclub.club.description}
                        </td>
                        <td>
                            ${aclub.club.clubOwner}
                        </td>
                        <td>
                            ${aclub.club.maxMembers}
                        </td>
                    </tr>
                </c:forEach>
            </table>            
        </div>
        <div id="indexRightColumn">
            yet more advertising goes here!
        </div>
    </body>
</html>
