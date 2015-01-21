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
        <div id="indexLeftColumn">Register new members page</div>
        
    <p>In order to access club information and join clubs, please provide us with the following information:</p>
    <div id="indexCentreColumn">
    <form class="registrationForm" action='submit_for_registration' method="post">
        <table id="register_form">
            <tr>
                <td>Firstname</td>
                <td><input type="text" size="31" maxlength="45" name="firstname"></td>
            </tr>
            <tr>
                <td>Surname</td>
                <td><input type="text" size="31" maxlength="45"  name="surname"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" size="31" maxlength="45" name="email"></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" size="31" maxlength="45" name="username"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" size="31" maxlength="45" name="password"></td>
            </tr>
            <tr>
                <td>Mobile no:</td>
                <td><input type="text" size="31" maxlength="16" name="phone"></td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><input type="date" size="31" maxlength="19" placeholder="dd/mm/yyyy" name="dob"</td>
            </tr>
            <tr>
                <td>Contact number ICE:</td>
                <td><input type="text" size="31" maxlength="19" minlength="7" name="contactICE"</td>
            </tr>
            <tr>
                <td>Location:</td>
                <td><input type="text" size="31" maxlength="31" name="location"></td>
            </tr>
            <tr>
                <td colspan="2">Read <a href="Terms">Terms</a> & Conditions and tick box to agree. 
                <input type="checkbox" name="checkbox" value="checkbox"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="submit" value="SUBMIT"></td>
            </tr>
        </table>
    </form>
    </div>
    </body>
</html>
