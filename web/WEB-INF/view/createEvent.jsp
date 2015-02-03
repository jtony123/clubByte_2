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
                clubName: {
                    required: true
                },
                description: {
                    required: true,
                    minlength: 6
                },
                location: {
                    required: true,
                    minlength: 6
                },
                dateandTime:{
                    required: true
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
    <form class="createEventForm" action='submit_for_registration' method="post">
        <table id="createEvent_form">
    <p>In order to create a new Event, please provide us with the following information:</p>                   
            <tr>
                <div><label for="clubName">Club Name</label></div>
                
                    <select id ="clubName" name ="clubName">
                        <c:forEach var="categ" items="${cats}">
                            <option value ="${categ.id}">${categ.name}</option>
                        </c:forEach>
                           
                    </select>
                   
                
            </tr>
            <tr>
                <div><label for="description">Description</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="150"
                           id="description"
                           name="description"
                           value="${param.description}">
                </div>
            </tr>
                        <tr>
                <div><label for="location">Location</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="150"
                           id="location"
                           name="description"
                           value="${param.location}">
                </div>
            </tr>
              <tr>
              <div<lable for="dateandTime">Date and Time of Event:</lable></div>
                <div>
                    <input type="dateandtime"
                           size="31"
                           maxlength="19"
                           placeholder="dd/mm/yyyy00:00"
                           name="dateandTime"
                </div>
            </tr>

            <tr>
                <div colspan="2">
                    <input type="submit" name="submit" value="SUBMIT">
                </div>
            </tr>
        </table>
    </form>
</div>
                <div id="indexRightColumn">Adverts go here.</div>
    </body>
</html>
