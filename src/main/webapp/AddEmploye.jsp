

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
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>

<body>

<div id="pagewidth">
    <div id="header">
        <h1 id="logo">DEPARTMENTS </h1>

        <h2 id="slogan">add a employe...</h2>
    </div>


    <form method="post" action="SaveEmploye.html">
    <p>Введите имя</p><input type="text" name="firstName" value=${firstName}>
    <p>Введите фамилию</p><input type="text" name="lastName" value=${lastName}>
    <p>Введите e-mail</p><input type="email" name="email" value="e-mail">
        <c:if test="${not empty errorValidate}"> Ошибка валидации ${errorValidate} </c:if>
    <p>Введите оклад</p><input type="number" name="salary" value=${salary}>
    <p>Введите дату рождения</p><input type="date" name="birthday" value=${birthday}>
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
