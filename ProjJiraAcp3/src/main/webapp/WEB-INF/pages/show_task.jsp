<%@ page import="ua.artcode.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Task task = (Task) request.getAttribute("task");%>
<%@include file="main_menu.jsp"%>
<div id="section">
<table border="1">
  <tr><td><b>TASK ID:</b></td><td><%=task.getId() %></td></tr>
  <tr><td><b>DESCRIPTION:</b></td><td><%=task.getDescription() %></td></tr>
  <tr><td><b>AUTHOR:</b></td><td></td></tr>
  <tr><td>Name:</td><td><%=task.getAuthor().getName() %></td></tr>
  <tr><td>e-mail:</td><td><%=task.getAuthor().getEmail() %></td></tr>
  <tr><td><b>EXECUTOR:</b></td><td></td></tr>
  <tr><td>Name:</td><td><%=task.getExecutor().getName() %></td></tr>
  <tr><td>e-mail:</td><td><%=task.getExecutor().getEmail() %></td></tr>
  <tr><td><b>PRIORITY:</b></td><td><%=task.getPriority() %></td></tr>
  <tr><td><b>STATE:</b></td><td><%=task.getState() %></td></tr>
  <tr><td><b>Create Date:</b></td><td><%=task.getCreateDate() %></td></tr>
  <tr><td><b>End Date:</b></td><td><%=task.getEndDate() %></td></tr>
  <tr><td><b>Planing hours:</b></td><td><%=task.getPlaningHours() %></td></tr>
  <tr><td><b>Executing hours:</b></td><td><%=task.getExecutingHours() %></td></tr>

</table>

  <a href="/menu/editTask?id=<%=task.getId()%>"  >Edit</a>
</div>
</body>
</html>
