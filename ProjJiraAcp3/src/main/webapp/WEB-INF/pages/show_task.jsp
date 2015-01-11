<%@ page import="ua.artcode.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.artcode.model.Comment" %>
<%@ page import="java.util.Set" %>
<% Task task = (Task) request.getAttribute("task");%>
<%@include file="main_menu.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<div id="section">
<table border="1" width="100%">
  <tr><td><b>ID ЗАДАЧИ:</b></td><td><%=task.getId() %></td></tr>
  <tr><td><b>ОПИСАНИЕ:</b></td><td><%=task.getDescription() %></td></tr>
  <tr><td><b>АВТОР:</b></td><td></td></tr>
  <tr><td>Имя:</td><td><%=task.getAuthor().getName() %></td></tr>
  <tr><td>e-mail:</td><td><%=task.getAuthor().getEmail() %></td></tr>
  <tr><td><b>ИСПОЛНИТЕЛЬ:</b></td><td></td></tr>
  <tr><td>Имя:</td><td><%=task.getExecutor().getName() %></td></tr>
  <tr><td>e-mail:</td><td><%=task.getExecutor().getEmail() %></td></tr>
  <tr><td><b>ПРИОРИТЕТ:</b></td><td><%=task.getPriority() %></td></tr>
  <tr><td><b>СОСТОЯНИЕ:</b></td><td><%=task.getState() %></td></tr>
  <tr><td><b>ДАТА СОЗДАНИЯ:</b></td><td><%=task.getCreateDate() %></td></tr>
  <tr><td><b>ДАТА ЗАКРЫТИЯ:</b></td><td><%=task.getEndDate() %></td></tr>
  <tr><td><b>ЗАПЛАНИРОВАННЫЕ ЧАСЫ:</b></td><td><%=task.getPlaningHours() %></td></tr>
  <tr><td><b>ЗАТРАЧЕНЫЕ ЧАСЫ:</b></td><td><%=task.getExecutingHours() %></td></tr>
</table>

<p><b>Задачу просмотрели:</b></p>
<% Set<User> visitors = task.getVisitors();
    for (User v : visitors){%>
      <%= v.getName() + "<br>" %>
    <%}%>

  <p><b>Коментарии:</b></p>
  <% List<Comment> comments = task.getComments();
    if (comments.size()>0){
    for (Comment c : comments){%>
  <%= c + "<br> -------------------- <br>" %>
  <%}
  }%>
</div>
<div id="nav">

  <form method="post" accept-charset="utf-8" action="/app/addComment?id=<%=task.getId()%>">
    Добавить коментарий:<br>
  <textarea name="comment" rows="2" cols="30">Тратата</textarea>
    <input type="submit" value="Добавить">
  </form>
  <b> <a href="/menu/editTask?id=<%=task.getId()%>"  >Редактировать задачу</a> <br></b>
</div>
</body>
</html>
