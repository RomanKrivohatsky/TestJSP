<%--
  Created by IntelliJ IDEA.
  User: rom4
  Date: 07.07.14
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form method="post" action="EditEmploye.html">
    <p>Введите имя</p><input type="text" name="firstName" value="имя" >
    <p>Введите фамилию</p><input type="text" name="lastName" value="фамилия">
    <p>Введите e-mail</p><input type="email" name="email" value="e-mail">
    <p>Введите оклад</p><input type="number" name="salary" value="оклад">
    <p>Введите дату рождения</p><input type="date" name="birthday" value="дата рождения">
    <input type="hidden" name="page" value="SaveEmploye">
    <input type="hidden" name="pageType" value="add">
    <input type="submit" name="submit" value="Сохранить">
</form>

<form method="get" action="home.html">
    <input type="hidden" name="page" value="home">
    <input type="submit" name="submit" value="На главную">
</form>

</body>
</html>
