<%-- 
    Document   : register
    Created on : 27-Nov-2014, 22:41:08
    Author     : jtony_000
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
                    required: true,
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
        <div align="center">
            Register new members page</div>
        <div id="singleColumn">


    <div align="center">
        In order to access club information and join clubs, please provide us with the following information:</div>
                  

    <form id="registrationForm"action='submit_for_registration' method="post">
        <table id="checkoutTable">
            <tr>
                <div><label for="name">Firstname:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="firstname"
                           name="firstname"
                           placeholder="first name"
                           value="${param.firstname}">
                </div>
            </tr
            <tr>
                <div><label for="name">Surname:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="surname"
                           name="surname"
                           value="${param.surname}">
                </div>
            </tr>
        </table>
        
        <table id="checkoutTable">
            <tr>
                <div><label for="email">Email:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           value="${param.email}">
                </div>
            </tr>
            <tr>
                <div><label for="email">Username:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="username"
                           name="username"
                           value="${param.username}">
                </div>
            </tr>
                        <tr>
                <div><label for="email">Password:</label></div>
                <div class="inputField">
                    <input type="password"
                           size="31"
                           maxlength="45"
                           id="password"
                           name="password"
                           value="${param.password}">
                </div>
            </tr>
            
            <tr>
                <div><label for="phone">Mobile no:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="phone"
                           name="phone"
                           value="${param.phone}">
                </div>
            </tr>
            <tr>

            </tr>
            <tr>
                <div><label for="dateofbirth">Date of Birth:</label></div>
                <div class="inputField">
                    <input type="date"
                           size="31"
                           maxlength="19"
                           placeholder="dd/mm/yyyy"
                           id="dob"
                           name="dob"
                           value="${param.dob}">
                </div>
            </tr>
            <tr>
                <div><label for="contactICE">Contact number ICE:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           minlength="7"
                           placeholder="phone number"
                           id="contactICE"
                           name="contactICE"
                           value="${param.contactICE}">
                </div>
            </tr>
            <tr>
                <div><label for="location">Location:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="31"
                           id="location"
                           name="location"
                           value="${param.location}">
                </div>
            </tr>
            <tr>
                <div colspan="2">
                    <input type="submit" name="submit" value="SUBMIT">
                    <input type="checkbox"
                           id="checkbox"
                           name="checkbox" 
                           value="checkbox">Read <a href="Terms">Terms</a> & Conditions and tick box to submit.
                </div>
            </tr>
        </table>
    </form>
</div>
    </body>
</html>
                
