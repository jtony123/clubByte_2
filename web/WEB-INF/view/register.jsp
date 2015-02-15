<%-- 
    Document   : register by gary
    Created on : 27-Nov-2014, 22:41:08
    Author     : jtony_000 by anthony
--%>

<script src="js/jquery.validate.js" type="text/javascript"></script>

<script type="text/javascript">
    
    $(document).ready(function(){
        $("#registrationForm").validate({
            rules: {
                name: "required",
                email: {
                    required: true,
                    email: true
                },
                username: {
                    required: true,
                    minlength: 6
                },
                password: {
                    required: true,
                    minlength: 6
                },
                phone: {
                    required: true,
                    minlength: 10
                },
                dob: {
                    required: true,
                    mydate: true
                },
                contactICE: {
                    required: true,
                    minlength: 10                    
                },
                checkbox:{
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
        <script language="JavaScript" src="js/ts_picker.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ClubByte</title>
    </head>
    <body>
        <div id="indexLeftColumn">Register new members page</div>
        
    <div id="indexCentreColumn">
    <form class="registrationForm" action='submit_for_registration'name="tstest" method="post">
        <table id="register_form">
            
                <p>In order to access club information and join clubs, please provide us with the following information:</p>

               <div><label for="firstName">First Name:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           name="firstName">
                </div> 
      
                <div><label for="surName">Surname:</label></div>
                <div class="inputField">
                <input type="text"
                       size="31" 
                       maxlength="45"
                       name="surname"></div>
            
                <div><label for="email">Email:</label></div>
                <div class="inputField">
                <input type="text"
                       size="31" 
                       maxlength="45" 
                       name="email">
                </div>
            
                <div><label for="username">Username:</div>
                <div class="inputField">
                <input type="text" 
                       size="31" 
                       maxlength="45"
                       name="username"></div>
            
                <div><label for="password">Password:</label></div>
                <div class="inputField">
                <input type="password" 
                       size="31" 
                       maxlength="45" 
                       name="password"></div>
  
                <div><label for="phone">Mobile no:</label></div>
                <div class="inputField">
                <input type="text" 
                       size="31" 
                       maxlength="16" 
                       name="phone"></div>
            
                <div><label for="dob">Date of Birth:</label></div>
                <div class="inputField">
                <input type="Text"size="31" name="dob" value="">
                <a href="javascript:show_calendar('document.tstest.dob', document.tstest.dob.value);">
                <img src="img/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a></div>
            
                <div><label for="contactICE">Contact number ICE:</label></div>
                <div class="inputField">
                <input type="text" 
                           size="31" 
                           maxlength="19" 
                           minlength="7" 
                           name="contactICE"</div>
           
                <div><label for="location">Location:</label></div>
                <div class="inputField">
                <input type="text" 
                       size="31" 
                       maxlength="31" 
                       name="location"></div>
            
                <div colspan="2">Read <a href="Terms">Terms</a> & Conditions and tick box to agree. 
                    <input type="checkbox" name="checkbox" value="checkbox"></div>
            
                <div colspan="2"><input type="submit" name="submit" value="SUBMIT"></div>
        </table>
    </form>
    </div>
        <div id="indexRightColumn">Adverts go here.</div>
    </body>
</html>