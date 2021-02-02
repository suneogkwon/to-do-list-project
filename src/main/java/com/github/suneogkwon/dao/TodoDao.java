package com.github.suneogkwon.dao;

import com.github.suneogkwon.dto.TodoDto;
import com.github.suneogkwon.setting.DatabaseInitializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

        return statement.executeUpdate(insertQuery);
    }

    public List<TodoDto> getTodo(){

    }

    public int updateTodo(TodoDto todoDto){

    }
}
