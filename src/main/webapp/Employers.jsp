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

<table border="1">
    <caption>������� �����������</caption>
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
                ${count}
            <td> ${Employe.firstName} </td>
            <td> ${Employe.lastName} </td>
            <td> ${Employe.email} </td>
            <td> ${Employe.salary} </td>
            <td> ${Employe.birthday} </td>

            <td>
                <form method="post" action="controller">
                    <input type="hidden" name="page" value="EditEmployeWithDep">
                    <input type="hidden" name="EmployeID" value=${Employe.employeID}>
                    <input type="hidden" name="departmentID" value=${departmentID}>

                    <p><input type="submit" name="submit" value="�������������"></p>
                </form>
            </td>
            <td>
                <form method="post" action="controller">
                    <input type="hidden" name="page" value="DeleteEmploye">
                        <input type="hidden" name="EmployeID" value=${Employe.employeID}>
                    <p><input type="submit" name="submit" value="�������"></p>
                </form>
            </td>


        </tr>
    </c:forEach>
</table>

<table border="0">
    <tr>
        <td valign="bottom">
            <form method="post" action="controller">
                <input type="hidden" name="page" value="AddEmploye">
                <input type="hidden" name="pageType" value="AddEmployeWithDep">
                <input type="hidden" name="departmentID" value=${departmentID}>
                <p><input type="submit" name="submit" value="�������� ����������"></p>
            </form>
        </td>
        <td>
            <form method="post" action="controller">
                <input type="hidden" name="page" value="home">
                <input type="submit" name="submit" value="�� �������">
            </form>
        </td>


    </tr>
</table>

</body>
</html>
