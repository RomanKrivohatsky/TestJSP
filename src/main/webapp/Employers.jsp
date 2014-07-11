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
    <title></title>
</head>
<body>

<style type="text/css">
    TABLE {
        background: maroon; /* Цвет фона таблицы */
        color: white; /* Цвет текста */
    }
    TD {
        background: navy; /* Цвет фона ячеек */
    }
</style>

<table border="0" align = "center">
    <tr>
        <td align="center" valign="top">
            <form method="get" action="AddEmploye.html">
                <input type="hidden" name="page" value="AddEmploye">
                <input type="hidden" name="pageType" value="AddEmployeWithDep">
                <input type="hidden" name="departmentID" value=${departmentID}>
                <p><input type="submit" name="submit" value="добавить сотрудника"></p>
            </form>
        </td>
        <td  align="center" valign="top">
            <form method="get" action="home.html">
                <input type="hidden" name="page" value="home">
                <input type="submit" name="submit" value="На главную">
            </form>
        </td>
    </tr>
</table>


<table border="1" align = "center">
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>E-mail</th>
        <th>Оклад</th>
        <th>Дата рождения</th>
        <th>редактировать</th>
    </tr>
    <c:forEach var="Employe" items="${requestScope.Employers}">
        <tr>
            <td> ${Employe.firstName} ${Employe.employeID}</td>
            <td> ${Employe.lastName} </td>
            <td> ${Employe.email} </td>
            <td> ${Employe.salary} </td>
            <td> ${Employe.birthday}  </td>
            <td>
                <form method="get" action="EditEmploye.html">
                    <input type="hidden" name="page" value="EditEmploye">
                    <input type="hidden" name="pageType" value="EditEmployeDep">
                    <input type="hidden" name="employeID" value=${Employe.employeID}>
                    <input type="hidden" name="departmentID" value=${Employe.departmentID}>
                    <p><input type="submit" name="submit" value="Редактировать"></p>
                </form>
            </td>
            <td>
                <form method="get" action="DeleteEmploye.html">
                    <input type="hidden" name="page" value="DeleteEmploye">
                        <input type="hidden" name="EmployeID" value=${Employe.employeID}>
                    <p><input type="submit" name="submit" value="Удалить"></p>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
