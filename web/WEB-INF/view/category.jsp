<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : category
    Created on : 27-Nov-2014, 11:55:15
    Author     : jtony_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%--<sql:query var="categories" dataSource="jdbc/clubByte_2">
    SELECT * FROM category
</sql:query>
    
<sql:query var="selectedCategory" dataSource="jdbc/clubByte_2">
    SELECT name FROM category WHERE id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>--%>


<%--query the database for clubs belonging to the category selected by the user
the category name is found on the request object--%>

<sql:query var="clubs" dataSource="jdbc/clubByte_2">
    SELECT * FROM Club WHERE category = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>
    
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
                                <a href="category?${category.name}" class="categoryButton">
                                    <div class="categoryText">
                                        ${category.name}
                                    </div>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

            </div>
        </div>
        
        <div id="indexCentreColumn">
            Clubs currently in the ${categoryName} category

            <table id="productTable">

                <c:forEach var="club" items="${clubs.rows}" varStatus="iter">

                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                        <td>
                            image from db
                        </td>
                        <td>
                            ${club.clubName}
                            <br>
                            <span class="smallText">${club.Description}</span>
                        </td>
                        <td>
                            #members; ${club.maxMembers}
                        </td>
                        <td>
                            limit; ${club.maxMembers}
                        </td>
                        <td>
                            <form action="addToCart" method="post">
                                <input type="hidden"
                                       name="productId"
                                       value="${club.id}">
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
