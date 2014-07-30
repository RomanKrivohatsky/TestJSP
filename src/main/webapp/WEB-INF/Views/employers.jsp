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
    <link rel="stylesheet" href="../../css/style.css" type="text/css"/>
</head>

<body>

<div id="pagewidth">
    <div id="header">
        <a href="home.html"> <h1 id="logo">DEPARTMENTS  </h1> </a>
        <h2 id="slogan">table with employers...</h2>
    </div>

    <form method="get" action="AddEmployee.html">
        <input type="hidden" name="pageType" value="AddEmployeWithDep">
        <input type="hidden" name="departmentID" value=${departmentID}>
        <p><input type="submit" name="submit" value="Add employee"></p>
    </form>

    <H2>${saveStatus}</H2>

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
        <c:forEach var="Employe" items="${requestScope.Employers}">
            <tr>
                <td><c:out value="${Employe.firstName}" /></td>
                <td> ${Employe.lastName} </td>
                <td> ${Employe.department.name} </td>
                <td> ${Employe.email} </td>
                <td> ${Employe.salary} </td>
                <fmt:formatDate var="date" pattern="yyyy-MM-dd" value="${Employe.birthday}"/>
                <td> ${date} </td>
                <td>
                    <form metdod="get" action="EditEmployee.html">
                        <input type="hidden" name="employeID" value=${Employe.employeID}>
                       <!-- <input type="hidden" name="departmentID" value="Employe.department.departmentID> -->

                        <p><input CLASS="button" type="submit" name="submit" value="Edit"></p>
                    </form>
                </td>
                <td>
                    <form metdod="get" action="DeleteEmployee.html">
                        <input type="hidden" name="EmployeID" value=${Employe.employeID}>
                        <input type="hidden" name="pageType" value="byDepartment">
                        <input type="hidden" name="departmentID" value=${departmentID}>
                        <p><input class="button" type="submit" name="submit" value="Delete"></p>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div id="footer">
        <p><a href="home.html">Homepage</a> | <a href="contact.html">contact</a> | <a
                href="http://validator.w3.org/check?uri=referer">html</a> | <a
                href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a
                href="http://www.mitchinson.net"> www.mitchinson.net</a> | tdis work is licensed under a <a
                rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons
            Attribution 3.0 License</a></p>
    </div>
</div>


</body>
</html>