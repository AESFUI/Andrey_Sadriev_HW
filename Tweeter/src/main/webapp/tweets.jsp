<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 07.11.16
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter</title>
</head>
<body>

<h1>Tweeter</h1>

<form action="/twitter" method="post">
    <label>Ваше сообщение: </label>
    <input type="text" name="message">
    <input type="submit">
</form>
<br>
<c:if test="${tweets.isEmpty()}">
    <p>Ничего пока нету :(</p>
</c:if>

<c:forEach items="${tweets}" var="tweet">
    <p>${tweet.message}</p>
    <form action="/twitter/fix" method="post">
        <label>Изменить собщение: </label>
        <input type="text" name="messagefix">
        <input type="hidden" name="id" value="${tweet.id}">
        <input type="submit">
    </form>

    <p>${tweet.createdAt}</p>
    <p>${tweet.comment}</p>

    <form action="/twitter/comment" method="post">
    <label>Добавить комментарий: </label>
    <input type="text" name="comment">
    <input type="hidden" name="id" value="${tweet.id}">
    <input type="submit" value="Добавить комментарий">
</form>

    <form action="/twitter/delete" method="post">
        <input type="hidden" name="id" value="${tweet.id}">
        <input type="submit" value="Удалить">
    </form>
</c:forEach>

</body>
</html>
