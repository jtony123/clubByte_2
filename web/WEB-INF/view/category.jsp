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
            <div class="leftColumnTitle">
                <p>Club Categories</p>                
                <div class="leftsideButtons">
                    <c:forEach var="category" items="${categories}">

                        <c:choose>
                            <c:when test="${category.id == pageContext.request.queryString}">
                                <div>
                                    <span>
                                        ${category.name}
                                    </span>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <a href="category?${category.id}">
                                    <div>
                                        ${category.name}
                                    </div>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
            <br><br>
            <button id="buttonsA" onclick="location.href='newclub'">Create a Club</button>
            </div>
        </div>
        </div>
        <div id="indexCentreColumn">
            Clubs currently in the ${selectedCategory} category

            <table id="clubTable">
                <td>Club Logo</td>
                <td>Name</td>
                <td>Description</td>
                <td>Spaces</td>
                <td>Click to see more....</td>
                <%--<c:forEach var="club" items="${categoryClubs}" varStatus="iter">--%>
                <c:forEach var="club" items="${notmyclubs}" varStatus="iter">

                    <tr class="${((iter.index % 2) == 0) ? 'oddline' : 'evenline'}">
                        <td>
                            image from db
                        </td>
                        <td>
                            ${club.clubName}
                        </td>
                        <td>
                            ${club.description}
                        </td>
                        <td>
                            ${club.maxMembers - club.clubMembersCollection.size()}
                        </td>
                        <td>
                            <form action="viewclub" method="post">
                                <input type="hidden"
                                       name="clubId"
                                       value="${club.clubID}">
                                <input id="viewButton"
                                        type="submit"
                                       value="VIEW">
                            </form>
                        </td>
                    </tr>

                </c:forEach>
            </table>
            
        </div>

        <div id="indexRightColumn">
            advertising goes here!
        </div>
