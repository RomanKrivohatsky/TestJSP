<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 03.07.14
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>DEPARTMENTS</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <link rel="stylesheet" href="/resource/style.css" type="text/css" />
</head>
<body>
<div id="pagewidth">
    <div id="header">
        <a href="home.html"> <h1 id="logo">DEPARTMENTS  </h1> </a>
        <h2 id="slogan">Table with Departments...</h2>
    </div>

    <H2>${deleteStatus}</H2>

<table class="CSSTableGenerator"  >
        <tr>
            <td>Название</td>
            <td>Город</td>
            <td>Редактировать</td>
            <td>Сотдрудники</td>
            <td>Удалить</td>
        </tr>
        <c:forEach var="Department" items="${requestScope.departmentList}">
            <tr>
                <td>${Department.name} </td>
                <td> ${Department.city}</td>
                <td>
                    <form method="get" action="/department/edit.html" >
                     <input type="hidden" name="departmentID" value=${Department.departmentID}>
                     <p><input type="submit" name="submit" value="edit"></p>
                    </form>
                </td>
                <td>
                    <form method="get" action="/employee/list.html">
                        <input type="hidden" name="departmentID" value=${Department.departmentID}>
                        <p><input type="submit" name="submit" value="List"></p>
                    </form>
                </td>
                <td>
                    <sf:form method="post" action="/department/delete.html" modelAttribute="department">
                        <input  type="hidden" name="departmentID" value=${Department.departmentID}>
                        <p><input type="submit" name="submit" value="Delete"></p>
                    </sf:form>
                </td>
            </tr>
        </c:forEach>
        </td>
    </table>
    <div id="footer">
        <p><a href="/home.html">Homepage</a> | <a href="contact.html">contact</a> | <a href="http://validator.w3.org/check?uri=referer">html</a> | <a href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a href="http://www.mitchinson.net"> www.mitchinson.net</a> | This work is licensed under a <a rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 License</a></p>
    </div>
</div>
</body>
</html>