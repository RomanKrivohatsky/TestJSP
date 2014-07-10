<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 03.07.14
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
</head>
<body>

<table align="center" border="0">
    <tr>
        <td  align="center" valign="top">
            <form method="get" action="AddDepartment.html">
                <input type="hidden" name="page" value="AddDepartment">

                <p><input type="submit" name="submit" value="Добавить отдел "></p>
            </form>
        </td>
        <td align="center" valign="top">
            <form method="get" action="home.html">
                <input type="hidden" name="page" value="home">
                <input type="submit" name="submit" value="На главную">
            </form>
        </td>
      </tr>
</table>
<table align="center" border="1" >
        <caption>Таблица отделов</caption>
        <tr>
            <th>Название</th>
            <th>Город</th>
            <th>Редактировать</th>
            <th>Сотдрудники</th>
            <th>Удалить</th>
        </tr>
        <c:forEach var="Department" items="${requestScope.Departments}">
            <tr>
                <td>${Department.name} </td>
                <td> ${Department.city}</td>
                <td>
                    <form method="get" action="EditDepartment.html">
                        <input type="hidden" name="page" value="EditDepartment">
                        <input type="hidden" name="departmentID" value=${Department.departmentID}>
                        <p><input type="submit" name="submit" value="Редактировать"></p>
                    </form>
                </td>
                <td>
                    <form method="get" action="Employers.html">
                        <input type="hidden" name="page" value="Employers">
                        <input type="hidden" name="pageType" value="byDepartment">
                        <input type="hidden" name="departmentID" value=${Department.departmentID}>
                        <p><input type="submit" name="submit" value="Список"></p>
                    </form>
                </td>
                <td>
                    <form method="get" action="DeleteDepartment.html">
                        <input type="hidden" name="page" value="DeleteDepartment">
                        <input type="hidden" name="departmentID" value=${Department.departmentID}>

                        <p><input type="submit" name="submit" value="Удалить"></p>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </td>
    </table>
</body>
</html>