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
        <h1>Register new members page</h1>
        <div id="singleColumn">


    <p>In order to access club information and join clubs, please provide us with the following information:</p>

    <form id="registrationForm"action='submit_for_registration' method="post">
        <table id="checkoutTable">
            <tr>
                <td><label for="name">Firstname:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="firstname"
                           name="firstname"
                           placeholder="first name"
                           value="${param.firstname}">
                </td>
            </tr
            <tr>
                <td><label for="name">Surname:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="surname"
                           name="surname"
                           value="${param.surname}">
                </td>
            </tr>
        </table>
        
        <table id="checkoutTable">
            <tr>
                <td><label for="email">email:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           value="${param.email}">
                </td>
            </tr>
            <tr>
                <td><label for="email">username:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="username"
                           name="username"
                           value="${param.username}">
                </td>
            </tr>
                        <tr>
                <td><label for="email">password:</label></td>
                <td class="inputField">
                    <input type="password"
                           size="31"
                           maxlength="45"
                           id="password"
                           name="password"
                           value="${param.password}">
                </td>
            </tr>
            
            <tr>
                <td><label for="phone">mobile no:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="phone"
                           name="phone"
                           value="${param.phone}">
                </td>
            </tr>
            <tr>

            </tr>
            <tr>
                <td><label for="dateofbirth">Date of Birth:</label></td>
                <td class="inputField">
                    <input type="date"
                           size="31"
                           maxlength="19"
                           placeholder="dd/mm/yyyy"
                           id="dob"
                           name="dob"
                           value="${param.dob}">
                </td>
            </tr>
            <tr>
                <td><label for="contactICE">contact number ICE:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           minlength="7"
                           placeholder="phone number"
                           id="contactICE"
                           name="contactICE"
                           value="${param.contactICE}">
                </td>
            </tr>
            <tr>
                <td><label for="location">location:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="31"
                           id="location"
                           name="location"
                           value="${param.location}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="submit" value="SUBMIT">
                </td>
            </tr>
        </table>
    </form>
</div>
    </body>
</html>
