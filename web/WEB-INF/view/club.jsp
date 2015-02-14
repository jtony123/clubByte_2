<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- 
    Document   : club
    Created on : 13-Jan-2015, 21:52:40
    Author     : jtony_000
--%>

<div id="indexLeftColumn">

    <div class="leftColumnTitle">
        ...this clubs details...       
        <br>
        <div class="leftsideButtons">

            <c:choose>
                <c:when test="${user == null}">
                    <a href="register">
                        Register
                    </a>
                </c:when>
                <c:otherwise>
                    <br>
                    <a href="mymessages">
                        My Messages
                    </a><br><br>
                    <a href="mymemberships">
                        My Memberships
                    </a><br><br>
                    <a href="myclubs">
                        My Clubs
                    </a><br><br>
                    <a href="myevents">
                        My Events
                    </a>
                </c:otherwise>
            </c:choose>
        </div> 
    </div>
</div>

<div id="indexCentreColumn"> 
    <div id="buttonsB">
        <div id="buttonsC">
            <c:choose>
                <c:when test="${selectedClub.clubID > 1}">
                    <form action="viewclub" method="get">
                        <input type="hidden" name="clubId" value="${selectedClub.clubID - 1}">
                        <input type="submit" value="<<< PREVIOUS CLUB">
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="viewclub" method="get">
                        <input type="hidden" name="clubId" value="${selectedClub}">
                        <input type="submit" value="..at the start.." disabled >
                    </form>
                </c:otherwise>
            </c:choose> 
        </div>

        <div id="buttonsC">.........................</div>

        <div id="buttonsC">
            <c:choose>
                <c:when test="${selectedClub.clubID < numClubs}">
                    <form action="viewclub" method="get">
                        <input type="hidden" name="clubId" value="${selectedClub.clubID + 1}">
                        <input type="submit" value="NEXT CLUB >>>">
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="viewclub" method="get">
                        <input type="hidden" name="clubId" value="${((selectedClub.clubID - 1) % (numClubs + 1))}">
                        <input type="submit" value="..at the end.." disabled >
                    </form>
                </c:otherwise>
            </c:choose> 
        </div>
    </div>
    <div style="float:left;">
        <br>
        <div class="centreColumnImages" >
            <img src="${initParam.clubImagePath}${selectedClub.clubImageFilename}" width="240" height="180" alt="no image uploaded"></img>
        </div>
        <div class="leftsideButtons">
            <%--<br> <br> <br> <br> <br> <br> <br>--%>   
            ${selectedClub.clubName}

            <div class ="leftColumnSmallText">
                owned by:${selectedClub.clubOwnerID.firstName} ${selectedClub.clubOwnerID.surName}
                <br>
                Category: ${selectedClub.category.name}&nbsp;&nbsp;&nbsp;Max no of members: ${selectedClub.maxMembers}
            </div>
            <br>
            Description: ${selectedClub.description}
            <br>  
            Parent Club: ${selectedClub.parentOrganisation}                  
            <br>
            <a href="${selectedClub.parentURL}" target="_blank">${selectedClub.parentURL}</a>
            <br><br>

        </div>
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
            </div>
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
                                <form action="compose_message" method="post">
                                    <input type="hidden" name="clubId" value="${selectedClub.clubID}">
                                    <input type="hidden" name="recipientID" value="${member.member1.memberID}">
                                    <input type="submit" value="SEND A MESSAGE">
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
                        <div id="buttonsC">
                            <form action="add_new_event" method="get">
                                <input type="hidden" name="clubId" value="${selectedClub.clubID}">
                                <input type="submit" value="ADD NEW EVENT">
                            </form>
                        </div>
                        <div id="buttonsC">
                            <form action="events" method="get">
                                <input type="hidden" name="clubId" value="${selectedClub.clubID}">
                                <input type="submit" value="VIEW EVENTS">
                            </form> 
                        </div>
                        <div id="buttonsC">
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
    <br><br><br><br><br><br> ...
</div>
<div id="indexRightColumn">
    yet more advertising goes here!
</div>
</body>
</html>
