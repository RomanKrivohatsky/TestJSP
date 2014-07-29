<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 07.07.14
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>DEPARTMENTS</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="../../style.css" type="text/css"/>
</head>

<body>

<div id="pagewidth">
    <div id="header">
        <h1 id="logo">DEPARTMENTS </h1>
        <h2 id="slogan">edit a department...</h2>
    </div>

    <H2>${saveStatus}</H2>

    <form method="post" action="SaveEmployee.html">
        <p>¬ведите им€</p><input type="text" name="firstName" value= <c:out value = "${firstName}"></c:out>  >
        <p>¬ведите фамилию</p> <input type="text" name="lastName" value= <c:out value = "${lastName}"></c:out> >
        <p>¬ведите e-mail</p> <input type="email" name="email" value= <c:out value = "${email}"></c:out> >
        <c:if test="${not empty emailError}"> Validation error: ${emailError} </c:if>
        <p>¬ведите оклад</p><input type="number" name="salary" value=<c:out value = "${salary}"></c:out>  >
        <c:if test="${not empty salaryError}"> Validation error: ${salaryError} </c:if>
        <fmt:formatDate var="date" pattern="yyyy-MM-dd" value="${birthday}"/>
            <p>¬ведите дату рождени€</p><input type="date" name="birthday" value="${date}"/>

            </p><input type="hidden" name="employeID" value=${employeID}>
            <input type="hidden" name="pageType" value=${pageType}>
            <p><select name="departmentID">

                <c:forEach var="Department" items="${Departments}">
                    <c:choose>
                        <c:when test="${not empty departmentID and Department.departmentID == departmentID}">
                            <option selected value="${Department.departmentID}">${Department.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${Department.departmentID}">${Department.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select></p>

            <input type="submit" name="submit" value="Save">
    </form>

    <div id="footer">
        <p><a href="home.html">Homepage</a> | <a href="contact.html">contact</a> | <a href="Employers.html">Emloyeers</a> | <a
                href="http://validator.w3.org/check?uri=referer">html</a> | <a
                href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a
                href="http://www.mitchinson.net"> www.mitchinson.net</a> | tdis work is licensed under a <a
                rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons
            Attribution 3.0 License</a></p>
    </div>
</div>

</body>
</html>