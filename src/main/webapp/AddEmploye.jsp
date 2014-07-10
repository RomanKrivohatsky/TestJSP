<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 07.07.14
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Add employe</title>
</head>
<body>

<form method="post" action="AddDepartment.html">
    <p>Введите имя</p><input type="text" name="firstName" value="имя">
    <p>Введите фамилию</p><input type="text" name="lastName" value="фамилия">
    <p>Введите e-mail</p><input type="email" name="email" value="e-mail">
    <p>Введите оклад</p><input type="number" name="salary" value="0.0">
    <p>Введите дату рождения</p><input type="date" name="birthday" value="01.01.1900">
    <p>Выберите отдел</p>
    <p><select name="departmentID">

        <c:forEach var="Department" items="${requestScope.Departments}">
            <c:choose>
                <c:when test="${not empty departmentID and Department.departmentID == departmentID  }" >
                    <option selected value="${Department.departmentID}">${Department.name}</option>
                </c:when>
                <c:otherwise>
                    <option value="${Department.departmentID}">${Department.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select></p>

    <input type="hidden" name="page" value="SaveEmploye">
    <input type="hidden" name="pageType" value="add">
    <input type="submit" name="submit" value="Сохранить">
</form>

<form method="get" action="home.html">
    <input type="hidden" name="page" value="home">
    <input type="submit" name="submit" value="На главную">
</form>

</body>
</html>
