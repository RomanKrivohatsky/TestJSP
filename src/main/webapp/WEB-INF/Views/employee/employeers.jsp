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
    <link rel="stylesheet" href="/resource/style.css" type="text/css"/>
</head>

<body>

<div id="pagewidth">
    <div id="header">
        <a href="/home.html"> <h1 id="logo">DEPARTMENTS  </h1> </a>
        <h2 id="slogan">table with employers...</h2>
    </div>

    <H2><c:if test="${not empty lastName}"> Employee ${lastName} has been deleted! </c:if></H2>

    <table class="CSSTableGenerator" >
        <tr>
            <td>Имя</td>
            <td>Фамилия</td>
            <td>Отдел</td>
            <td>E-mail</td>
            <td>Оклад</td>
            <td>Дата рождения</td>
            <td>Редактировать</td>
            <td>Удалить</td>
        </tr>
        <c:forEach var="Employee" items="${requestScope.employeers}">
            <tr>
                <td><c:out value="${Employee.firstName}" /></td>
                <td> ${Employee.lastName} </td>
                <td> ${Employee.department.name} </td>
                <td> ${Employee.email} </td>
                <td> ${Employee.salary} </td>
                <fmt:formatDate var="date" pattern="dd-mm-yyyy" value="${Employee.birthday}"/>
                <td> ${date} </td>
                <td>
                    <form metdod="get" action="/employee/edit.html">
                        <input type="hidden" name="employeeID" value=${Employee.employeeID}>
                        <input type="submit" name="submit" value="Edit">
                    </form>
                </td>
                <td>
                    <form method="post" action="/employee/delete.html">
                        <input type="hidden" name="employeeID" value=${Employee.employeeID}>
                        <input type="hidden" name="departmentID" value=${departmentID}>
                        <input type="submit" name="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div id="footer">
        <p><a href="/home.html">Homepage</a> | <a href="/contact.html">contact</a> | <a
                href="http://validator.w3.org/check?uri=referer">html</a> | <a
                href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a
                href="http://www.mitchinson.net"> www.mitchinson.net</a> | tdis work is licensed under a <a
                rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons
            Attribution 3.0 License</a></p>
    </div>
</div>


</body>
</html>