<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : events
    Created on : 12-Feb-2015, 15:40:19
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
                    <td>Date & Time</td>                
                    
                    <td>Event Details</td>
                    <td>Attending</td>
                </tr>
                <c:forEach var="event" items="${clubEvents}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            hi<%--${event.club.clubName}--%>
                        </td>
                        <td>
                            ${event.eventName}
                        </td>    
                        <td>  
                            ${event.eventVenue}
                        </td>
                        <td>
                            ${event.eventDate} 
                        </td>
<!--                        <td>
                            ${event.eventTime} 
                        </td>-->
                        <td>
                            ${event.eventDetails} 
                        </td>
                        <td>
                            <form action="attend_event" method="post">
                                <input type="hidden"
                                       name="thisEvent"
                                       value="${event.eventID}">
                                <input type="submit"
                                       value="I'M GOING">
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
