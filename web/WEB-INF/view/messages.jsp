<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- 
    Document   : messages
    Created on : 13-Feb-2015, 22:58:02
    Author     : jtony_000
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!--<!DOCTYPE html>-->
<!--<html>-->
<!--    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clubs you are a member of</title>
    </head>-->
<!--    <body>-->
        <div id="indexLeftColumn">
     <div class="leftColumnTitle">
        ...messages you have sent...       
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
            your INBOX 
            <br>
            <table id="myEventTable"> 
                <tr>
                    <td>
                        Club
                    </td>
                    <td>From</td>
                    <td>Date sent</td>                
                    <td>Message details</td>
                    <td>Mark as read</td>
                </tr>
                <c:forEach var="msg" items="${myMsgs}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            ${msg.clubclubID.clubName}
                        </td>
                        <td>
                            ${msg.member1.userName}
                        </td>
                        <td>
                            ${msg.messageDate}
                        </td>
                        <td>
                            ${msg.messageDetails}
                        </td>
                        <td>
                            mark as read
                        </td>
                    </tr>
                </c:forEach>   
            </table>  
            <br><br>
            
            SENT MESSAGES
            <br>
            <table id="myEventTable"> 
                <tr>
                    <td>
                        Club
                    </td>
                    <td>To</td>
                    <td>Date sent</td>                
                    <td>Message details</td>
                    <td>read yet?</td>
                </tr>
                <c:forEach var="outmsg" items="${sentMsgs}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            ${outmsg.clubclubID.clubName}
                        </td>
                        <td>
                            ${outmsg.toMembermemberID.userName}
                        </td>
                        <td>
                            ${outmsg.messageDate}
                        </td>
                        <td>
                            ${outmsg.messageDetails}
                        </td>
                        <td>
                            yes:no
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
