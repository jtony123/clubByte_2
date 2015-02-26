<%-- 
    Document   : createEvent
    Created on : 30-Jan-2015, 14:23:28
    Author     : gary
--%>

<script src="js/jquery.validate.js" type="text/javascript"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $("#newEventForm").validate({
            rules: {
                name: "required",
                eventName: {
                    required: true
                },
                eventVenue: {
                    required: true,
                    minlength: 6
                },
                eventDate:{
                    required: true
                },
                eventTime:{
                    required: true
                },
                eventDetails: {
                    required: true,
                    minlength: 6
                }
            }
        });
        
    });
</script>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script language="JavaScript" src="js/ts_picker.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ClubByte</title>
    </head>
    <body>
        <div id="indexLeftColumn">Create New Events</div>

<div id="indexCentreColumn">
    <form class="createEventForm" action='add_new_event'name="tstest" method="post">
        <table id="createEvent_form">
    <p>In order to create a new Event, please provide us with the following information:</p>                   
            
                    <div><label for="eventName">Event Name:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="eventName"
                           name="eventName"
                           value="${param.eventName}">
                </div>   
            
                        
                <div><label for="eventVenue">Event Venue</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="150"
                           id="eventVenue"
                           name="eventVenue"
                           value="${param.eventVenue}">
                </div>
            
              
              <div><label for="eventDate">Date & Time of Event:</label></div>
              <div class="inputField">
                  <input type="Text"size="31" placeholder="DD/MM/YY HH:MM" name="eventDate" value="">
              <a href="javascript:show_calendar('document.tstest.eventDate', document.tstest.eventDate.value);">
              <img src="img/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a> </div>
<!--              <div><label for="eventTime">Time of Event:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           placeholder="00:00"
                           name="eventTime"
                </div>-->
            
             
                <div><label for="eventDetails">Event details</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="150"
                           id="eventDetails"
                           name="eventDetails"
                           value="${param.eventDetails}"></div>
                           <div><label for="recurring">Recurring</label></div>
                           <INPUT TYPE="radio" name="command" value="0"/>Every week
                           <INPUT TYPE="radio" NAME="command" VALUE="1"/>Every month
              <div colspan="2">
                    <input type="submit" name="add_new_event" value="ADD THIS EVENT">
                </div>
                           
        </table>
    </form>
                           
</div>
                <div id="indexRightColumn">Adverts go here.</div>
    </body>
</html>
