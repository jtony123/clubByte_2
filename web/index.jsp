<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 27-Nov-2014, 11:54:15
    Author     : jtony_000
--%>

        <div id="indexLeftColumn">
            <div class="leftColumnTitle">
                <p>All about clubByte and how it works, what it can do for you.</p>
                    <div class="leftsideButtons">
                        <c:choose>
                            <c:when test="${user_name == null}">
                                <a href="register">
                                Register
                                </a>
                            </c:when>
                            <c:otherwise>
                                <br>
                                <a href="mymessages">
                                My Messages
                                </a><br><br>
                                <a href="myclubs">
                                My Memberships
                                </a><br><br>
                                <a href="ownerclubs">
                                My Clubs
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


