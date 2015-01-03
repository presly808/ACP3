<%@ page import="ua.artcode.model.Task" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Task> tasks = (List<Task>)request.getAttribute("Tasks");%>

<%@include file="main_menu.jsp"%>
<div id="section">
<p><b>Спиок задач:</b></p>
<table border="1">
  <tr>
    <td><p>id</p></td>
    <td><p>Дата создания</p></td>
    <td><p>Описание</p></td>
    <td><p>Автор</p></td>
    <td><p>Исполнитель</p></td>
    <td><p>Статус</p></td>
    <td><p>Приоритет</p></td>

  </tr>
  <%for (Task t: tasks){ %>
    <tr>
      <td><a href="/app/showtask?id=<%=t.getId()%>"><%=t.getId()%></a></td>
      <td><%=t.getCreateDate()%></td>
      <td><%=t.getDescription()%></td>
      <td><%=t.getAuthor()%></td>
      <td><%=t.getExecutor()%></td>
      <td><%=t.getState()%></td>
      <td><%=t.getPriority()%></td>

    </tr>
 <% }%>
</table>
  </div>
</body>
</html>
