<%@ page contentType="text/html;charset=windows-1251" %>
<html>
<body>
<h2>������� ��������!</h2>


<table border="0" >
    <tr>
        <td valign="bottom">�������� ����� </td>
        <td valign="bottom">
            <form method="post" action="addDepartment">
                <input type="hidden" name="page" value="AddDepartment">

                <p><input type="submit" name="submit" value="��������"></p>
            </form>
        </td>
    </tr>
    <tr>
        <td valign="bottom">�������� ���������� </td>
        <td valign="bottom">
            <form method="post" action="AddEmploye">
                <input type="hidden" name="page" value="AddEmploye">
                <input type="hidden" name="pageType" value="AddEmploye">
                <p><input type="submit" name="submit" value = "��������"></p>
            </form>
        </td>
    </tr>
    <tr>
        <td>������ �������</td>
        <td>
            <form method="post" action="DepartmentList">
                <input type="hidden" name="page" value="DepartmentList">
                <p><input type="submit" name="submit" value = "��������"></p>
            </form>
        </td>
    </tr>
    <tr>
        <td>������ �������</td>
        <td>
            <form method="post" action="DepartmentList">
                <input type="hidden" name="page" value="DepartmentList">
                <p><input type="submit" name="submit" value = "�������� ������ �������"></p>
            </form>
        </td>
    </tr>
    <tr>
        <td>������ �����������</td>
        <td>
            <form method="post" action="Employers">
                <input type="hidden" name="page" value="Employers">
                <input type="hidden" name="pageType" value="all">
                <p><input type="submit" name="submit" value = "�������� 2"></p>
            </form>
        </td>
    </tr>
    <tr>
        <td>��������</td>
        <td>
            <form method="post" action="Contacts">
                <input type="hidden" name="page" value="Contacts">
                <p><input type="submit" name="submit" value = "��������"></p>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
