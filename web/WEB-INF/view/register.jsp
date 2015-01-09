<%-- 
    Document   : register
    Created on : 27-Nov-2014, 22:41:08
    Author     : jtony_000
--%>

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

    <form action='submit' method="post">
        <table id="checkoutTable">
            <tr>
                <td><label for="name">Firstname:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="firstname"
                           name="firstname"
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
                <td><label for="creditcard">Date of Birth:</label></td>
                <td class="inputField">
                    <input type="date"
                           size="31"
                           maxlength="19"
                           id="dob"
                           name="dob"
                           value="${param.dob}">
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
