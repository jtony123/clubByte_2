<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : myevents
    Created on : 13-Feb-2015, 00:13:06
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
            <div class="leftColumnTitle">
                Here are the events coming up
            </div>  
            <br><br>
<!--            <div class="leftsideButtons">
            <button id="buttonsA" onclick="location.href='newclub'">Create Club</button>
            </div>-->
        </div>        
        <div id="indexCentreColumn">
            These are the events you are attending coming up 
            <table id="myEventTable"> 
                <tr>
                    <td>
                        Club
                    </td>
                    <td>Event Name</td>
                    <td>Venue</td>
                    <td>Date</td>                
                    <td>Time</td>
                    <td>Event Details</td>
                    <td>Attending</td>
                </tr>
                <c:forEach var="myevent" items="${myEvents}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            hi<%--${event.club.clubName}--%>
                        </td>
                        <td>
                            ${myevent.event.eventName}
                        </td>    
                        <td>  
                            ${myevent.event.eventVenue}
                        </td>
                        <td>
                            ${myevent.event.eventDate} 
                        </td>
                        <td>
                            ${myevent.event.eventTime} 
                        </td>
                        <td>
                            ${myevent.event.eventDetails} 
                        </td>
                        <td>
                            <form action="index" method="get">
                                <input type="hidden"
                                       name="thisEvent"
                                       value="${myevent.event.eventID}">
                                <input type="submit"
                                       value="NOT GOING">
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
