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
        background: maroon; /* ���� ���� ������� */
        color: white; /* ���� ������ */
    }
    TD {
        background: navy; /* ���� ���� ����� */
    }
</style>

<table border="0" align = "center">
    <tr>
        <td align="center" valign="top">
            <form method="get" action="AddEmploye.html">
                <input type="hidden" name="page" value="AddEmploye">
                <input type="hidden" name="pageType" value="AddEmployeWithDep">
                <input type="hidden" name="departmentID" value=${departmentID}>
                <p><input type="submit" name="submit" value="�������� ����������"></p>
            </form>
        </td>
        <td  align="center" valign="top">
            <form method="get" action="home.html">
                <input type="hidden" name="page" value="home">
                <input type="submit" name="submit" value="�� �������">
            </form>
        </td>
    </tr>
</table>


<table border="1" align = "center">
    <tr>
        <th>���</th>
        <th>�������</th>
        <th>E-mail</th>
        <th>�����</th>
        <th>���� ��������</th>
        <th>�������������</th>
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
                    <p><input type="submit" name="submit" value="�������������"></p>
                </form>
            </td>
            <td>
                <form method="get" action="DeleteEmploye.html">
                    <input type="hidden" name="page" value="DeleteEmploye">
                        <input type="hidden" name="EmployeID" value=${Employe.employeID}>
                    <p><input type="submit" name="submit" value="�������"></p>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
