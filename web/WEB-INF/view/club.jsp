<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
           this clubs details.....           
           <br>
                <div class="leftColumnImages" >
                <img src="${initParam.clubImagePath}${selectedClub.clubImageFilename}" width="240" height="180" alt="no image uploaded"></img>
                </div>
                <div class="leftsideButtons">
                <br> <br> <br> <br> <br> <br> <br>    
                Club Name: ${selectedClub.clubName}
                <br>
                <div class ="leftColumnSmallText">
                owned by:${selectedClub.clubOwnerID.firstName} ${selectedClub.clubOwnerID.surName}
                </div>
                <br>
                Description: ${selectedClub.description}
                <br>
                Max no of members: ${selectedClub.maxMembers}
                <br>
                Category: ${selectedClub.category.name}
                <br>
                Parent Club: ${selectedClub.parentOrganisation}
                </div>
                <br>
                <a href="${selectedClub.parentURL}" target="_blank">Link to Parent Organisation</a>
                <br><br>
            </div>
        </div>
               
        <div id="indexCentreColumn">    
            <c:choose>
                <%--<c:when test="${clubMembers.size() == 0}">--%>
                <c:when test="${isMember == null}">
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
                    <br>

            <table id="myClubTable">  
                <tr>
                <td>Username</td>
                <td>email address</td>
                <td>location</td>
                <td>Date joined</td>
                </tr>
                <c:forEach var="member" items="${clubMembers}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            ${member.member1.userName}&nbsp&nbsp
                        </td>    
                        <td>  
                            ${member.member1.emailAddress}&nbsp&nbsp
                        </td>
                        <td>
                            ${member.member1.location}&nbsp&nbsp
                        </td>
                        <td>
                            ${member.member1.dob}&nbsp
                        </td>
                        <td><div id="buttonsA">
                            <form action="sendmessage" method="post">
                                <input type="hidden"
                                       name="clubId"
                                       value="${member.member1.emailAddress}">
                                <input type="submit"
                                       value="SEND MESSAGE">
                            </form>
                            </div>
                        </td>
                    </tr>
                    
                </c:forEach>
            </table><br><br><br><br>
            
                        <div id="buttonsB">
                            <d:set var="owner" value="${selectedClub.clubOwnerID.userName}"/>
                            <d:set var="user" value="${user.userName}"/>
                            <d:choose>
                                <d:when test="${fn:contains(owner, user)}">
                                    <div id="buttonsB">
                                        <form action="add_new_event" method="get">
                                        <input type="hidden" name="clubId" value="${selectedClub.clubID}">
                                        <input type="submit" value="ADD NEW EVENT">
                                        </form>
                                        </div>
                                        <div id="buttonsB">
                                        <form action="events" method="get">
                                        <input type="hidden" name="clubId" value="${selectedClub.clubID}">
                                        <input type="submit" value="VIEW EVENTS">
                                        </form> 
                                        </div>
                                        <div id="buttonsB">
                                        <form action="deleteclub" method="post">
                                        <input type="hidden" name="clubId" value="${selectedClub.clubID}">
                                        <input type="submit" value="DELETE THIS CLUB :(">
                                        </form>
                                        </div>
                                </d:when>
                                <d:otherwise>                
                                    <form action="leaveclub" method="post">
                                        <input type="hidden" name="clubId" value="${selectedClub.clubID}">
                                        <input type="submit" value="LEAVE THIS CLUB">
                                    </form>
                                </d:otherwise>
                            </d:choose>   
                        </div>          
            </c:otherwise>
        </c:choose>
        </div>
        <div id="indexRightColumn">
            yet more advertising goes here!
        </div>
    </body>
</html>
