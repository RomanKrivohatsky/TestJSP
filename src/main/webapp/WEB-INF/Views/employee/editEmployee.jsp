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
        <a href="/home.html"><h1 id="logo">DEPARTMENTS </h1></a>

        <h2 id="slogan">edit a department...</h2>
    </div>

    <div id="wrapper" class="clearfix">

        <H2>${saveStatus}</H2>

        <fmt:formatDate var="date" type="both" pattern="yyyy-MM-dd" value="${employee.birthday}"/>

        <sf:form method="post" action="save.html?pageType=${pageType}" modelAttribute="employee"
                 cssClass="form-container">

        <table>
            <tr>
                <td>Введите имя:</td>
                <td><sf:input path="firstName" cssClass="form-field"/></td>
                <td><sf:errors path="firstName" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Введите фамилию:</td>
                <td><sf:input path="lastName" cssClass="form-field"/></td>
                <td><sf:errors path="lastName" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Введите e-mail:</td>
                <td><sf:input path="email" cssClass="form-field"/></td>
                <td><sf:errors path="email" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Введите оклад:</td>
                <td><sf:input path="salary" cssClass="form-field"/></td>
                <td><sf:errors path="salary" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Введите дату рождения:</td>
                <td><sf:input path="birthday" type="date" value="${date}" cssClass="form-field"/></td>
                <td><sf:errors path="birthday" cssClass="error"/></td>
            </tr>
            <tr>
                <td>ВЫберите отдел:</td>
                <td>
                    <sf:select path="department">
                        <sf:options items="${departments}" itemValue="departmentID" itemLabel="name"/>
                    </sf:select>
                </td>
            </tr>
            </sf:form>
        </table>

        <input type="hidden" name="employeeID" value=${employee.employeeID}>
        <input type="submit" name="submit" value="Save" class="submit-button">

    </div>

    <div id="footer">
        <p><a href="/home.html">Homepage</a> | <a href="/contact.html">contact</a> | <a
                href="/employee/list.html">Emloyeers</a> | <a
                href="http://validator.w3.org/check?uri=referer">html</a> | <a
                href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a
                href="http://www.mitchinson.net"> www.mitchinson.net</a> | tdis work is licensed under a <a
                rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons
            Attribution 3.0 License</a></p>
    </div>
</div>

</body>
</html>