<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : category
    Created on : 27-Nov-2014, 11:55:15
    Author     : jtony_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    
        <div id="indexLeftColumn">
            <div id="welcomeText">
                <p>Club Categories</p>
                    <c:forEach var="category" items="${categories}">

                        <c:choose>
                            <c:when test="${category.id == pageContext.request.queryString}">
                                <div class="categoryButton" id="selectedCategory">
                                    <span class="categoryText">
                                        ${category.name}
                                    </span>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <a href="category?${category.id}" class="categoryButton">
                                    <div class="categoryText">
                                        ${category.name}
                                    </div>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

            </div>
            <br><br>
            <button onclick="location.href='newclub'">Create Club</button>
        </div>
        
        <div id="indexCentreColumn">
            Clubs currently in the ${selectedCategory} category

            <table id="clubTable">
                <td>Club Logo</td>
                <td>Name, Description</td>
                <td>Member spaces remaining</td>
                <td>Click to join</td>
                <%--<c:forEach var="club" items="${categoryClubs}" varStatus="iter">--%>
                <c:forEach var="club" items="${notmyclubs}" varStatus="iter">

                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            image from db
                        </td>
                        <td>
                            ${club.clubName}
                            <br>
                            <span class="smallText">${club.description}</span>
                        </td>
                        <td>
                            ${club.maxMembers - club.clubMembersCollection.size()}
                        </td>
                        <td>
                            <form action="joinclub" method="post">
                                <input type="hidden"
                                       name="clubId"
                                       value="${club.clubID}">
                                <input type="submit"
                                       value="JOIN">
                            </form>
                        </td>
                    </tr>

                </c:forEach>

</table>
            
        </div>

        <div id="indexRightColumn">
            advertising goes here!
        </div>
