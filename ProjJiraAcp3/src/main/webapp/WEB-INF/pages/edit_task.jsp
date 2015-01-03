<%@ page import="ua.artcode.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.artcode.service.UserServiceImpl" %>
<%@ page import="ua.artcode.model.Task" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="main_menu.jsp"%>
<% Task task = (Task) request.getAttribute("task");%>

<div id="section">
<h1>Редактирование задачи id = <%=task.getId()%></h1>

<form method="post" action="/app/editTaskController">
<input type="hidden" name="id" value="<%=task.getId()%>">
  Описание задачи:<br>
  <textarea name="desc" rows="25" cols="100">
   <%=task.getDescription()%>
  </textarea>
  <br>
  Приоритет: <br>
  <select name="taskPriority" value ="0" >
    <option value="1">Критический</option>
    <option value="2">Высокий</option>
    <option value="3">Средний</option>
    <option value="4">Низкий</option>
  </select>
  <br>

  Статус задачи: <br>
  <select name="taskState" value ="1" >
    <option value="1">New</option>
    <option value="2">Proceed</option>
    <option value="3">Close</option>
    <option value="4">Reopen</option>
  </select>
  <br>

  Автор: <%=task.getAuthor().getName()%>
  <br>
  Выбирите исполнителя:<br>
  <% UserServiceImpl userService = (UserServiceImpl) application.getAttribute("userService");
      List<User> executors = userService.showAllUsers();
  %>
    <select name="executor">
        <%for (User u:executors){%>
            <option value="<%=u.getId()%>"><%=u.getName()%></option>
        <%}%>
    </select>
    <br>
  Кол-во запланированых часов:
  <input type="text" name="pHours" value=" <%=task.getPlaningHours()%>">
  <br>
  Кол-во использованных часов:
  <input type="text" name="eHours" value="">
  <br>
  Дата создания задачи : <%=task.getCreateDate()%>
  <br>
  Дата окончания задачи:
  <input type="text" name="endDate" value="DD-MM-YYYY">
  <br>
  <input type="submit" value="Cохранить">
</form>
</div>
</body>
</html>
