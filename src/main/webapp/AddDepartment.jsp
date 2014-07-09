<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 04.07.14
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>AddDepartment</title>
</head>
<body>

<form method="post" action="controller">
    <p>Введите название</p><input type="text" name="name" value="название" >
    <p>Введите город</p><input type="text" name="city" value="город">
    <input type="hidden" name="page" value="SaveDepartment">
    <input type="hidden" name="pageType" value="add">
    <input type="submit" name="submit" value="Сохранить">
</form>

<form method="post" action="home">
    <input type="hidden" name="page" value="home">
    <input type="submit" name="submit" value="На главную">
</form>

</body>
</html>
