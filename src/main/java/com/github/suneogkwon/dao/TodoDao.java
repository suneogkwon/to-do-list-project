package com.github.suneogkwon.dao;

import com.github.suneogkwon.dto.TodoDto;
import com.github.suneogkwon.setting.DatabaseInitializer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {

    public int addTodo(TodoDto todoDto) throws SQLException {
        DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        Connection connection = DriverManager.getConnection(databaseInitializer.getDbUrl(),
                databaseInitializer.getUser(),
                databaseInitializer.getPassword());

        Statement statement = connection.createStatement();

        String insertQuery = "insert into todo(title, name, sequence) values('"
                + todoDto.getTitle() + "', '"
                + todoDto.getName() + "', "
                + todoDto.getSequence() + ");";

        connection.close();
        statement.close();

        return statement.executeUpdate(insertQuery);
    }

    public List<TodoDto> getTodo() throws SQLException {
        DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        Connection connection = DriverManager.getConnection(databaseInitializer.getDbUrl(),
                databaseInitializer.getUser(),
                databaseInitializer.getPassword());

        Statement statement = connection.createStatement();

        List<TodoDto> todoDtoList = new ArrayList<>();
        String selectQuery = "select id, title, name, sequence, type, regdate from todo order by regdate desc";
        ResultSet resultSet = statement.executeQuery(selectQuery);
        while (resultSet.next()) {
            TodoDto todoDto = new TodoDto();
            todoDto.setId(resultSet.getLong("id"));
            todoDto.setTitle(resultSet.getString("title"));
            todoDto.setName(resultSet.getString("name"));
            todoDto.setSequence(resultSet.getInt("sequence"));
            todoDto.setType(resultSet.getString("type"));
            todoDto.setRegdate(resultSet.getString("regdate"));
            todoDtoList.add(todoDto);
        }

        connection.close();
        statement.close();
        resultSet.close();

        return todoDtoList;
    }

    public int updateTodo(TodoDto todoDto) throws SQLException {
        DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        Connection connection = DriverManager.getConnection(databaseInitializer.getDbUrl(),
                databaseInitializer.getUser(),
                databaseInitializer.getPassword());

        Statement statement = connection.createStatement();
        String nextType = "DOING";

        if(todoDto.getType().equals("DOING")){
            nextType = "DONE";
        }
        String updateQuery = "update todo set type = '" + nextType + "' where id = " + todoDto.getId() + ";";
        return statement.executeUpdate(updateQuery);
    }
}
