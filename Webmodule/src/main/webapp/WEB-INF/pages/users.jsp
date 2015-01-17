<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: mountin
  Date: 28/12/2014
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List usersList = (List) application.getAttribute("users"); %>
<html>
<head>
    <title></title>
</head>
<body>
<%= users.get[0] %>
</body>
</html>
