<%@ page import="ua.artcode.model.User" %>
<%User client = (User)session.getAttribute("client");%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <title>Джира</title>
</head>

<body>

<div id="header">
    <p>Вы вошли под пользователем:<%= client.getName()%> <br>
        <a href="/menu/addTask">1.Добавить задачу</a>
        <a href="/menu/selectTasks">2.Просмотреть задачу</a></p>
</div>







