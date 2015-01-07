<%@ page import="ua.artcode.model.User" %>
<%User client = (User)session.getAttribute("client");%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <title>Джира</title>
    <style>

        #header {
            background-color:darkgreen;
            color:white;
            text-align:center;
            padding:5px;

        }
        #nav {
            line-height:30px;
            background-color:#eeeeee;
            height:300px;
            width:100px;
            float:left;
            padding:5px;
        }
        #section {
            width:700px;
            float:left;
            padding:10px;
        }
        #footer {
            background-color:black;
            color:white;
            clear:both;
            text-align:center;
            padding:5px;
        }
    </style>
</head>

<body>

<div id="header">
    <p>Вы вошли под пользователем:<%= client.getName()%> <br>
        <a href="/menu/addTask">1.Добавить задачу</a>
        <a href="/menu/selectTasks">2.Просмотреть задачу</a></p>
</div>







