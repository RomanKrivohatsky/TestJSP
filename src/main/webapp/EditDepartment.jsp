<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 07.07.14
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title></title>
</head>
<body>

<form method="post" action="controller">
    <p>Введите название</p><input type="text" name="name" value=${name} >
    <p>Введите город</p><input type="text" name="city" value=${city}>
    </p><input type="hidden" name="departmentID" value=${departmentID}>
    <input type="hidden" name="page" value="SaveDepartment">
    <input type="hidden" name="pageType" value="edit">
    <input type="submit" name="submit" value="Сохранить">
</form>

<form method="post" action="controller">
    <input type="hidden" name="page" value="home">
    <input type="submit" name="submit" value="На главную">
</form>

</body>
</html>
