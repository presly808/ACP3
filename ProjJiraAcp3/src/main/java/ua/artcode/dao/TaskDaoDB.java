/*
package ua.artcode.dao;

import ua.artcode.db.ConnectionFactory;
import ua.artcode.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;



public class TaskDaoDB implements ITaskDao {

    Connection connection = null;
    @Override
    public void create(Task task) {
        try {
            connection = ConnectionFactory.getINSTANCE().newConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tasks (description, state_id, " +
                    "priority_id, author_id, executor_id, project_id, createDate, endDate, planingHours, executingHours)"+
            "VALUES (?,?,?,?,?,?,?,?,?,?)");
            SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            preparedStatement.setString(1, task.getDescription());
            preparedStatement.setString(2, String.valueOf(task.getState_id()));
            preparedStatement.setString(3, String.valueOf(task.getPriority_id()));
            preparedStatement.setString(4, String.valueOf(task.getAuthor_id()));
            preparedStatement.setString(5, String.valueOf(task.getExecutor_id()));
            preparedStatement.setString(6, String.valueOf(task.getProject_id()));
            preparedStatement.setString(7, sdf.format(task.getCreateDate()));
            preparedStatement.setString(8, sdf.format(task.getEndDate()));
            preparedStatement.setString(9, sdf.format(task.getPlaningHours()));
            preparedStatement.setString(10, sdf.format(task.getExecutingHours()));
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Task read(Integer id) {
        try {
            connection = ConnectionFactory.getINSTANCE().newConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT id, description, state_id, priority_id, author_id,"
                    + "executor_id,project_id, createDate, endDate, planingHours,executingHours FROM tasks where id=?");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new Task(rs.getInt("id"), rs.getString("description"), rs.getInt("state_id"), rs.getInt("priority_id"),
                        rs.getInt("author_id"), rs.getInt("executor_id"), rs.getInt("project_id"), rs.getDate("createDate"),
                        rs.getDate("endDate"), rs.getDate("planingHours"), rs.getDate("executingHours"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Integer id, Task changed) {
        return false;
    }

    @Override
    public void delete(Integer id) {

    }
}
*/
