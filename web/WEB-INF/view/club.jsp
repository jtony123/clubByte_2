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
           this clubs details: name, etc...
           <br><br>
            <c:forEach begin="0" end="0" step="1" var="clubdetails" items="${clubMembers}" varStatus="iter">
                Club Name: ${clubdetails.club.clubName}
                <br><br>
                Club Owner:${clubdetails.club.clubOwnerID.firstName} ${clubdetails.club.clubOwnerID.surName}
                <br><br>
                Description: ${clubdetails.club.description}
                <br><br>
                Max no of members: ${clubdetails.club.maxMembers}
                <br><br>
                Category: ${clubdetails.club.category.name}
                <br><br>
                Parent Club: ${clubdetails.club.parentOrganisation}
                <br><br>
                <a href="${clubdetails.club.parentURL}" target="_blank">Link to Parent Organisation</a>
                <br><br>
                <form action="leaveclub" method="post">
                    <input type="hidden"
                            name="clubId"
                            value="${clubdetails.club.clubID}">
                    <input type="submit"
                        value="LEAVE THIS CLUB">
                </form>
            </c:forEach>
        </div>        
        <div id="indexCentreColumn">
            This Clubs Members 
            <table id="myClubTable">  
                <td>Username</td>
                <td>email address</td>
                <td>location</td>
                <td>Date joined</td>
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
