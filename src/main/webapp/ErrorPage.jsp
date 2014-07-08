<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 08.07.14
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


<h1>Ошибка обработки данных!</h1>

<h2>${errorStatus}</h2>

<form method="post" action="controller">
    <input type="hidden" name="page" value="home">
    <input type="submit" name="submit" value="На главную">
</form>

</body>
</html>
