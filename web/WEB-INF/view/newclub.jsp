<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : newclub
    Created on : 17-Jan-2015, 18:36:43
    Author     : Dylan
--%>

<script src="js/jquery.validate.js" type="text/javascript"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $("#newClubForm").validate({
            rules: {
                name: "required",
                clubName: {
                    required: true,
                    minlength:4
                },
                description: {
                    required: true,
                    minlength: 6
                },
                category: {
                    required: true,
                },
                maxMembers: {
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
        <div>Create New Club</div>
        <div id="singleColumn">


    <p>In order to create a new club, please provide us with the following information:</p>

    <form id="newClubForm"action='submit_new_club' method="post">
        
        <table id="checkoutTable">
            <tr>
                <div><label for="clubName">Club Name:</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="clubName"
                           name="clubName"
                           value="${param.clubName}">
                </div>
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
                <div><label for="category">Category</label></div>
                <div>
                    <select id ="category" name ="category"">
                        <c:forEach var="categ" items="${cats}">
                            <option value ="${categ.id}">${categ.name}</option>
                        </c:forEach>
                           
                    </select>
                    
                </div>
            </tr>
                        <tr>
                <div><label for="maxMembers">Maximum Members</label></div>
                <div class="inputField">
                    <input type="number"
                           size="4"
                           maxlength="4"
                           id="maxMembers"
                           name="maxMembers"
                           value="${param.maxMembers}">
                </div>
            </tr>
            <tr>
                <div><label for="parentOrganisation">Organisation</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="parentOrganisation"
                           name="parentOrganisation"
                           value="${param.parentOrganisation}">
                </div>
            </tr>
            <tr>
                <div><label for="parentURL">Organisation URL</label></div>
                <div class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="clubName"
                           name="parentURL"
                           value="${param.parentURL}">
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
    </body>
</html>

