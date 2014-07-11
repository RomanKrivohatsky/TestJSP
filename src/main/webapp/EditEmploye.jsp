<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 07.07.14
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>

<form method="post" action="SaveEmploye.html">
    <p>Введите имя</p><input type="text" name="firstName" value=${firstName} >
    <p>Введите фамилию</p> <input type="text" name="lastName" value=${lastName}>
    <p>Введите e-mail</p> <input type="email" name="email" value=${email}>
    <c:if test="${not empty errorValidate}"> Ошибка валидации ${errorValidate} </c:if>
    <p>Введите оклад</p><input type="number" name="salary" value=${salary}>
    <p>Введите дату рождения</p><input type="date" name="birthday" value=${birthday}>
    </p><input type="hidden" name="employeID" value=${employeID}>
    </p><input type="hidden" name="departmentID" value=${departmentID}>
    <input type="hidden" name="page" value="SaveEmploye">
    <input type="hidden" name="pageType" value="edit">
    <input type="submit" name="submit" value="Сохранить">

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

</form>

<form method="get" action="home.html">
    <input type="hidden" name="page" value="home">
    <input type="submit" name="submit" value="На главную">
</form>

</body>
</html>
