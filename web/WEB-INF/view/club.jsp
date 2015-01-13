<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : club
    Created on : 13-Jan-2015, 21:52:40
    Author     : jtony_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Club Details</title>
    </head>
    <body>
        <div id="indexLeftColumn">
           the club name etc...!
        </div>        
        <div id="indexCentreColumn">
            This Clubs Members 
            <table id="myClubTable">  
                <td>Username</td>
                <td>email address</td>
                <td>location</td>
                <td>age</td>
                <c:forEach var="member" items="${clubMembers}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            ${member.member1.userName}
                        </td>    
                        <td>  
                            ${member.member1.emailAddress}
                        </td>
                        <td>
                            ${member.member1.location}
                        </td>
                        <td>
                            ${member.member1.dob}
                        </td>
                        <td>
                            <form action="viewclub" method="post">
                                <input type="hidden"
                                       name="clubId"
                                       value="${member.member1.emailAddress}">
                                <input type="submit"
                                       value="SEND MESSAGE">
                            </form>
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
