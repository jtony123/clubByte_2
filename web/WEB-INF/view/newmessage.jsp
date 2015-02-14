<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- 
    Document   : newmessage
    Created on : 13-Feb-2015, 20:34:27
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
        <div id="indexLeftColumn">Send a message</div>
        
    <div id="indexCentreColumn">
    <form class="registrationForm" action='post_message' method="post">
        <div id="messagebox">
            
            To:&nbsp&nbsp${recipient.userName}
            <br>
            
            <input type="text" size="100" maxlength="300" name="message">
            <input type="submit" value="SEND">
            
        </div>
    </form>
    </div>
        <div id="indexRightColumn">Adverts go here.</div>
    </body>
</html>
