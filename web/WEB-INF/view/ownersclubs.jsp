<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<%-- 
    Document   : ownersclubs
    Created on : 09-Feb-2015, 21:28:11
    Author     : jtony_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clubs you are the owner of</title>
    </head>
    <body>
        <div id="indexLeftColumn">
            <div class="leftColumnTitle">
                Some options for you..
            </div>  
            <br><br>
            <div class="leftsideButtons">
            <button id="buttonsA" onclick="location.href='newclub'">Create Club</button>
            </div>
        </div>        
        <div id="indexCentreColumn">
            Your Clubs 
            <table id="myClubTable"> 
                <td>
                    Logo
                </td>
                <td>Club Name</td>
                <td>Description</td>
                <td>#Current/Max Members</td>
                <td>Club Details</td>
                <c:forEach var="aclub" items="${clubsOwned}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            <img src="${initParam.clubImagePath}${aclub.clubImageFilename}" width="120" height="90" alt="${aclub.clubName}"></img>
                        </td>
                        <td>
                            ${aclub.clubName}
                        </td>    
                        <td>  
                            ${aclub.description}
                        </td>
                        <td>
                            ${aclub.clubMembersCollection.size()} / ${aclub.maxMembers}
                        </td>
                        <td>
                            <form action="viewclub" method="get">
                                <input type="hidden"
                                       name="clubId"
                                       value="${aclub.clubID}">
                                <input type="submit"
                                       value="EDIT THIS CLUB">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>            
        </div>
        <div id="indexRightColumn">
            money rolling in here!
        </div>
    </body>
</html>
