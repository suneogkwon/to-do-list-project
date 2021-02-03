package com.github.suneogkwon.dao;

import com.github.suneogkwon.dto.TodoDto;
import com.github.suneogkwon.setting.DatabaseInitializer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private String driver = "org.h2.Driver";
    private String dbUrl = "jdbc:h2:mem:todolist";
    private String user = "sa";
    private String password = "";
    private String createTableQuery = "CREATE TABLE todo ( " +
            "id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT, " +
            "title VARCHAR(255) NOT NULL, " +
            "name VARCHAR(100) NOT NULL, " +
            "sequence INT(1) NOT NULL, " +
            "type VARCHAR(20) DEFAULT 'TODO', " +
            "regdate DATETIME DEFAULT NOW(), " +
            "PRIMARY KEY (id) );";
    private boolean isCreateTable = false;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public int addTodo(TodoDto todoDto) throws SQLException, ClassNotFoundException {
        createTable();
        Class.forName(driver);
        String query = "insert into todo(title, name, sequence) values(?,?,?);";

        connection = DriverManager.getConnection(dbUrl,user,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,todoDto.getTitle());
        preparedStatement.setString(2,todoDto.getName());
        preparedStatement.setInt(3,todoDto.getSequence());
        int executeUpdate = preparedStatement.executeUpdate();

        connection.close();
        statement.close();

        return executeUpdate;
    }

    public List<TodoDto> getTodo() throws SQLException, ClassNotFoundException {
        createTable();
        Class.forName(driver);
        String query = "select id, title, name, sequence, type, regdate from todo order by regdate desc sequence asc";

        connection = DriverManager.getConnection(dbUrl,user,password);
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        List<TodoDto> todoDtoList = new ArrayList<>();
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

    public int updateTodo(TodoDto todoDto) throws SQLException, ClassNotFoundException {
        createTable();
        Class.forName(driver);
        String query = "update todo set type = ? where id = ?;";

        connection = DriverManager.getConnection(dbUrl,user,password);


        String nextType = "DOING";

        if(todoDto.getType().equals("DOING")){
            nextType = "DONE";
        }


        return statement.executeUpdate(updateQuery);
    }

    private void createTable() throws ClassNotFoundException, SQLException {
        if(isCreateTable)
           return;
        Class.forName(driver);

        connection = DriverManager.getConnection(dbUrl,user,password);
        statement = connection.createStatement();
        statement.execute(createTableQuery);
        isCreateTable = true;

        connection.close();
        statement.close();
    }
}
