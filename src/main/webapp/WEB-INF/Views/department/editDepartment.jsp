<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 07.07.14
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>DEPARTMENTS</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="/resource/style.css" type="text/css"/>
</head>

<body>

<div id="pagewidth">
    <div id="header">
        <a href="/home.html"> <h1 id="logo">DEPARTMENTS  </h1> </a>
        <h2 id="slogan">add a department...</h2>
    </div>

    <H2>${saveStatus}</H2>

    <sf:form method="post" action="save.html?pageType=${pageType}"   modelAttribute="department">
        <p>Department name</p><input type="text" name="name" value= <c:out value = "${department.name}"></c:out> >
        <font color="#ff0000" size="+1">
        <c:if test="${not empty errors.name}"> Validation error: ${errors.name} </c:if></font>
        <font color="#ff0000" size="+1">
        <c:if test="${not empty errors.nameEmpty}"> Validation error: ${errors.nameEmpty} </c:if></font>

        <p>¬ведите город</p><input type="text" name="city" value= <c:out value = "${department.city}"></c:out> >
        <font color="#ff0000" size="+1">
        <c:if test="${not empty errors.city}"> Validation error: ${errors.city} </c:if></font>

        <input type="hidden" name="departmentID" value= <c:out value = "${department.departmentID}"></c:out> >
    <p><input type="submit" name="submit" value="Save"> </p>
    </sf:form>

    <div id="footer">
        <p><a href="/home.html">Homepage</a> | <a href="/contact.html">contact</a> | <a href="/department/list.html">Departments</a> |<a
                href="http://validator.w3.org/check?uri=referer">html</a> | <a
                href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a
                href="http://www.mitchinson.net"> www.mitchinson.net</a> | tdis work is licensed under a <a
                rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons
            Attribution 3.0 License</a></p>
    </div>
</div>

</body>
</html>