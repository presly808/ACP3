<%@ page import="java.util.List" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title></title>
</head>
<body>
JAVA<br>
<% List<String> users = (List) application.getAttribute("users");%>
<%for (String u : users){%>
  Name: <%= u%><br>
<%}%>
<br>
JSTL
<br>
<c:forEach var="user" items="${users}">
 Name <c:out value="${user}"/> <br>
</c:forEach>



</body>
</html>
