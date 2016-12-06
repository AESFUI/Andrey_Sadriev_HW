<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 29.11.2016
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>

<form:form action="/posts/login" method="post" modelAttribute="users">
    <table>
        <tr>
            <td><form:label path="userName">Логин</form:label></td>
            <td><form:input path="userName"/></td>
            <td><form:errors path="userName"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Пароль</form:label></td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password"/></td>
        </tr>
    </table>
    <input type="submit" name="Вход на форум" value="Вход"/>
</form:form>

</body>
</html>
