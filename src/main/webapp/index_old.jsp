<%@ page contentType="text/html;charset=windows-1251" %>
<html>
<head>

</head>
<body>
<h2 align="center">������� ��������!</h2>

<table align="center" border="0">
    <tr>
        <td valign="top">
            <form method="get" action="AddDepartment.html">
                <input type="hidden" name="page" value="AddDepartment">
                <p><input width="80" type="submit" name="submit" value="�������� �����"></p>
            </form>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <form method="get" action="AddEmploye.html">
                <input type="hidden" name="page" value="AddEmploye">
                <input type="hidden" name="pageType" value="AddEmploye">
                <p><input width="80" type="submit" name="submit" value="�������� ���������� "></p>
            </form>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <form method="get" action="DepartmentList.html">
                <input type="hidden" name="page" value="DepartmentList">
                <p><input width="80" type="submit" name="submit" value="������ �������"></p>
            </form>
        </td>
    </tr>
    <tr>
        <td valign="top">
        <form method="get" action="Employers.html">
            <input type="hidden" name="page" value="Employers">
            <input type="hidden" name="pageType" value="all">
            <p><input  width="80" type="submit" name="submit" value="������ �����������"></p>
        </form>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <form method="get" action="Contacts.jsp">
                <input type="hidden" name="page" value="Contacts">
                <p><input width="80" type="submit" name="submit" value="��������"></p>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
