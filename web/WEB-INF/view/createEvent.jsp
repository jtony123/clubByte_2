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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ClubByte</title>
    </head>
    <body>
        <div id="indexLeftColumn">Create New Events</div>

<div id="indexCentreColumn">
    <form class="createEventForm" action='add_new_event' method="post">
        <table id="createEvent_form">
    <p>In order to create a new Event, please provide us with the following information:</p>                   
            <tr>
                    <div><label for="eventName">Event Name:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="eventName"
                           name="eventName"
                           value="${param.eventName}">
                </div>   
            </tr>
                        <tr>
                <div><label for="eventVenue">Event Venue</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="150"
                           id="eventVenue"
                           name="eventVenue"
                           value="${param.eventVenue}">
                </div>
            </tr>
              <tr>
              <div><label for="eventDate">Date of Event:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           placeholder="dd/mm/yyyy"
                           name="eventDate"
                </div>
            </tr>
             <tr>
              <div><label for="eventTime">Time of Event:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           placeholder="00:00"
                           name="eventTime"
                </div>
            </tr>
             <tr>
                <div><label for="eventDetails">Event details</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="150"
                           id="eventDetails"
                           name="eventDetails"
                           value="${param.eventDetails}">
                </div>
            </tr>

            <tr>
                <div colspan="2">
                    <input type="submit" name="add_new_event" value="ADD THIS EVENT">
                </div>
            </tr>
        </table>
    </form>
</div>
                <div id="indexRightColumn">Adverts go here.</div>
    </body>
</html>
