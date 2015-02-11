<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : myclubs
    Created on : 13-Jan-2015, 15:09:56
    Author     : jtony_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clubs you are a member of</title>
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
            Your are a member of these clubs 
            <table id="myClubTable"> 
                <td>
                    Logo
                </td>
                <td>Club Name</td>
                <td>Description</td>
                <td>#Current/Max Members</td>
                <td>Club Details</td>
                <c:forEach var="aclub" items="${clubsMemberNotOwner}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            <img src="${initParam.clubImagePath}${aclub.club.clubImageFilename}" width="120" height="90" alt="${aclub.club.clubName}"></img>
                        </td>
                        <td>
                            ${aclub.club.clubName}
                        </td>    
                        <td>  
                            ${aclub.club.description}
                        </td>
                        <td>
                            ${aclub.club.clubMembersCollection.size()} / ${aclub.club.maxMembers}
                        </td>
                        <td>
                            <form action="viewclub" method="get">
                                <input type="hidden"
                                       name="clubId"
                                       value="${aclub.club.clubID}">
                                <input type="submit"
                                       value="VIEW">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>            
        </div>
        <div id="indexRightColumn">
            yet more advertising goes here!
        </div>
    </body>
</html>
