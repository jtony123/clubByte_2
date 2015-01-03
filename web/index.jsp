<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 27-Nov-2014, 11:54:15
    Author     : jtony_000
    testing a new commit
--%>


<%--<sql:query var="categories" dataSource="jdbc/clubByte_2">
    SELECT * FROM category
</sql:query>--%>
        <div id="indexLeftColumn">
            <div id="welcomeText">
                <p>All about clubByte and how it works, what it can do for you.</p>
                    <div class="headerWidget">
                        <a href="register">
                        Register
                        </a>
                    </div>        
            </div>
        </div>
        
        <div id="indexCentreColumn">
            <c:forEach var="category" items="${categories}">
                <div class="categoryBox">
                    <a href="category"${category.name}>  
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
            advertising goes here!
        </div>


