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
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>DEPARTMENTS</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="/resource/style.css" type="text/css"/>
</head>

<body>

<div id="pagewidth">
    <div id="header">
        <a href="home.html"><h1 id="logo">DEPARTMENTS </h1></a>

        <h2 id="slogan">edit a department...</h2>
    </div>

    <H2>${saveStatus}</H2>

    <sf:form method="post" action="save.html?pageType=${pageType}" modelAttribute="employee">
        <p>¬ведите им€</p>
        <input type="text" name="firstName" value=<c:out value="${employee.firstName}"></c:out>>
        <font color="#ff0000" size="+1">
            <c:if test="${not empty errors.firstName}"> Validation error: ${errors.firstName} </c:if></font>

        <p>¬ведите фамилию</p>
        <input type="text" name="lastName" value=<c:out value="${employee.lastName}"></c:out>>
        <font color="#ff0000" size="+1">
            <c:if test="${not empty errors.lastName}"> Validation error: ${errors.lastName} </c:if></font>

        <p>¬ведите e-mail</p>
        <input type="email" name="email" value=<c:out value="${employee.email}"></c:out>>
        <font color="#ff0000" size="+1">
            <c:if test="${not empty errors.email}"> Validation error: ${errors.email} </c:if></font>

        <p>¬ведите оклад</p>
        <input type="number" name="salary" value=<c:out value="${employee.salary}"></c:out>>
        <font color="#ff0000" size="+1">
            <c:if test="${not empty errors.salary}"> Validation error: ${errors.salary} </c:if></font>

        <fmt:formatDate var="date" type="both" pattern="yyyy-MM-dd" value="${employee.birthday}"/>
        <p>¬ведите дату рождени€</p>
        <input type="date" name="birthday" value="${date}">
        <font color="#ff0000" size="+1">
            <c:if test="${not empty errors.birthday}"> Validation error: ${errors.birthday} </c:if></font>

        <p><sf:select path="department">
            <sf:options items="${departments}" itemValue="departmentID" itemLabel="name"/>
        </sf:select></p>

        <input type="hidden" name="employeID" value=
            <c:out value="${employee.employeID}"></c:out>>

        <input type="hidden" name="employeID" value=${employeID}>
        <input type="submit" name="submit" value="Save">
    </sf:form>

    <div id="footer">
        <p><a href="home.html">Homepage</a> | <a href="contact.html">contact</a> | <a
                href="Employers.html">Emloyeers</a> | <a
                href="http://validator.w3.org/check?uri=referer">html</a> | <a
                href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a
                href="http://www.mitchinson.net"> www.mitchinson.net</a> | tdis work is licensed under a <a
                rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons
            Attribution 3.0 License</a></p>
    </div>
</div>

</body>
</html>