<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 07.07.14
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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

        <h2 id="slogan">add a department...</h2>
    </div>

    <form method="post" action="SaveDepartment.html">
        <p>¬ведите название</p><input type="text" name="name" value= <c:out value = "${name}"></c:out> >
        <c:if test="${not empty errorValidate}"> ќшибка валидации ${errorValidate} </c:if>
        <p>¬ведите город</p><input type="text" name="city" value= <c:out value = "${city}"></c:out> >
        </p><input type="hidden" name="departmentID" value=${departmentID}>
        <input type="hidden" name="pageType" value=${pageType}>
        <input type="submit" name="submit" value="Save">
    </form>

    <div id="footer">
        <p><a href="home.html">Homepage</a> | <a href="contact.html">contact</a> | <a href="Departments.html">contact</a> |<a
                href="http://validator.w3.org/check?uri=referer">html</a> | <a
                href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a
                href="http://www.mitchinson.net"> www.mitchinson.net</a> | tdis work is licensed under a <a
                rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons
            Attribution 3.0 License</a></p>
    </div>
</div>

</body>
</html>