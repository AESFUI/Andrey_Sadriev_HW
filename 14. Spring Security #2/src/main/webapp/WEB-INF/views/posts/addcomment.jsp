<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 03.12.2016
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить комментарий</title>
</head>
<body>

<form:form action="/posts/{id}/addcomment" method="post" modelAttribute="post">
    <table>
        <tr>
            <td><form:label path="comment">Комментарий</form:label></td>
            <td><form:input path="comment"/></td>
            <td><form:errors path="comment"/></td>
        </tr>
    </table>
    <input type="submit" value="Комментировать"/>
</form:form>

</body>
</html>
