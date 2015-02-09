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
            <div class="leftColumnTitle">
           this clubs details: name, etc...
           <div class="leftsideButtons">
           <br>
                <div class="leftColumnSmallText">
                <img src="${initParam.clubImagePath}${selectedClub.clubImageFilename}" width="240" height="180" alt="no image uploaded"></img>
                </div>
                <br>    
                Club Name: ${selectedClub.clubName}
                <br>
                <div class ="leftColumnSmallText">
                owned by:${selectedClub.clubOwnerID.firstName} ${selectedClub.clubOwnerID.surName}
                </div>
                <br><br>
                Description: ${selectedClub.description}
                <br>
                <div class="leftColumnSmallText">
                Max no of members: ${selectedClub.maxMembers}
                </div>
                <br>
                Category: ${selectedClub.category.name}
                <br><br>
                Parent Club: ${selectedClub.parentOrganisation}
                <br>
                <a href="${selectedClub.parentURL}" target="_blank">Link to Parent Organisation</a>
                <br><br>
                </div>
            </div>
        </div>        
        <div id="indexCentreColumn">
             
            <c:choose>
                <c:when test="${clubMembers.size() == 0}">
                    Only paid up members can view the other members of a club
                    <br>This clubs fee structure..........
                    <br>
                    <br>Type of fee: ${selectedClub.feefeeID.name}
                    <br>Amount to be paid: ${selectedClub.feefeeID.amount}
                    <br>For a period of: ${selectedClub.feefeeID.period}
                    <br>Payment type(s) accepted: ${selectedClub.feefeeID.type}
                    <br>Payment details(the small print): ${selectedClub.feefeeID.details}
                    <br>
                    <br>
                            <form action="payfees" method="post">
                                <input type="hidden"
                                       name="clubId"
                                       value="${selectedClub.clubID}">
                                <input type="submit"
                                       value="JOIN THIS CLUB">
                            </form>
                </c:when>
                <c:otherwise>
                This Clubs Members
                <form action="leaveclub" method="post">
                    <input type="hidden"
                            name="clubId"
                            value="${selectedClub.clubID}">
                    <input type="submit"
                        value="LEAVE THIS CLUB">
                </form>
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
                </c:otherwise>
            </c:choose>
            </table>            
        </div>
        <div id="indexRightColumn">
            yet more advertising goes here!
        </div>
    </body>
</html>
