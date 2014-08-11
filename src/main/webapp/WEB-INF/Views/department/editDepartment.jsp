<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 07.07.14
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <h2 id="slogan">add a department...</h2>
    </div>

    <div id="wrapper" class="clearfix">

        <H2>${saveStatus}</H2>

        <sf:form method="post" action="save.html?pageType=${pageType}" modelAttribute="department"
                 cssClass="form-container">

            <table>
                <tr>
                    <td>Department name:</td>
                    <td><sf:input path="name" cssClass="form-field"/></td>
                    <td><sf:errors path="name" cssClass="form-field-error"/></td>

                </tr>
                <tr>
                    <td>City:</td>
                    <td><sf:input path="city" cssClass="form-field"/></td>
                    <td><sf:errors path="city" cssClass="form-field-error"/></td>

                </tr>
            </table>

            <input type="hidden" name="departmentID" value=
                <c:out value="${department.departmentID}"></c:out>>

            <p><input type="submit" name="submit" value="Save" class="submit-button"></p>
        </sf:form>

        <sf:form method="post" action="save.html?pageType=${pageType}" modelAttribute="department"
                 cssClass="form-container">


            Department name: <sf:input path="name" cssClass="form-field"/> <sf:errors path="name" cssClass="error"/>


            City:<sf:input path="city" cssClass="form-field"/>
            <sf:errors path="city" cssClass="error"/>

            <input type="hidden" name="departmentID" value=
                <c:out value="${department.departmentID}"></c:out>>

            <div class="submit-container">
                <p><input type="submit" name="submit" value="Save" class="submit-button"></p>
            </div>
            >
        </sf:form>

    </div>

    <div id="footer">
        <p><a href="/home.html">Homepage</a> | <a href="/contact.html">contact</a> | <a href="/department/list.html">Departments</a>
            |<a
                    href="http://validator.w3.org/check?uri=referer">html</a> | <a
                    href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a
                    href="http://www.mitchinson.net"> www.mitchinson.net</a> | tdis work is licensed under a <a
                    rel="license" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons
                Attribution 3.0 License</a></p>
    </div>
</div>

</body>
</html>