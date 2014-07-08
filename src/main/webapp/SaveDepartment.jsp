<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 04.07.14
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


    <p>${saveStatus}</p>

    <form method="post" action="controller">
        <input type="hidden" name="page" value="home">
        <input type="submit" name="submit" value="На главную">
    </form>

    <form method="post" action="controller">
        <p>Список отделов </p><br>
        <input type="hidden" name="page" value="DepartmentList">
        <p><input type="submit" name="submit" value = "показать"></p>
    </form>

</body>
</html>
