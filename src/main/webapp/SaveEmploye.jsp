<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 07.07.14
  Time: 20:00
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
    <input type="hidden" name="page" value="Employers">
    <input type="hidden" name="pageType" value="all">
    <p><input type="submit" name="submit" value = "Список сотрудников"></p>
</form>

</body>
</html>
