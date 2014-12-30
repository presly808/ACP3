<%@ page import="ua.artcode.model.User" %>

<%User client = (User)session.getAttribute("client");%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главное меню</title>
</head>
<body>
<%= client.getName()%> <br>
<h1>
<a href="../add_task.jsp">1.Добавить задачу</a>
</h1>
</body>
</html>
