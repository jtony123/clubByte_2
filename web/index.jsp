<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 27-Nov-2014, 11:54:15
    Author     : jtony_000
--%>

        <div id="indexLeftColumn">
            <div class="leftColumnTitle">

                    <div class="leftsideButtons">
                        <c:choose>
                            <c:when test="${user == null}">
                                <p>All about ClubByte, what it can do for you....all from one place</p>
                                <ul>
                                    <li> Pay or collect your fees easily and safely</li><br>
                                    <li> keep up to date with all your clubs, societies, groups, classes...</li>
                                    <li> create your own clubs, groups, societies....and manage them all easily</li>
                                    <li> keep all your members informed from one place</li>
                                </ul>
                                <a href="register">
                                Register
                                </a>
                            </c:when>
                            <c:otherwise>
                                <br>
                                <a href="mymessages">
                                My Messages
                                </a><br><br>
                                <a href="mymemberships">
                                My Memberships
                                </a><br><br>
                                <a href="myclubs">
                                My Clubs
                                </a><br><br>
                                <a href="myevents">
                                My Events
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </div>        
            </div>
        </div>
        
        <div id="indexCentreColumn">
            <c:forEach var="category" items="${categories}">
                <div class="categoryBox">
                    <a href="category?${category.id}">  
                        <div class="categoryImage">
                            <img src="${initParam.categoryImagePath}${category.name}.jpg"
                                alt="${category.name}">
                            </img>
                        </div>
                    
                        <div class="categoryLabelText">
                        ${category.name}
                        </div>
                        <div class="categoryDescription">                  
                        ${category.categoryBlurb}
                        </div>
                    </a>   
                </div>
            </c:forEach>
        </div>

        <div id="indexRightColumn">
            <div class="rightColumnTitle">
                Advertising goes here!
                <br>
                Good rates
            </div>
            
        </div>


