<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: mountin
  Date: 28/12/2014
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<% List users = (List) application.getAttribute("users"); %>
<html>
<head>
    <title></title>
</head>
<body>


<%for(Object name: users){%>

name=<%=name%>

<%}%>

JSTS<hr>
<c:forEach var="user" items="${users}" >

    <c:out value="${user}"></c:out>

</c:forEach>

</body>
</html>
