package com.github.suneogkwon.setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializerSample {
    private String driver = "org.h2.Driver";
    private String dbUrl = "jdbc:h2:mem:todolist";
    private String user = "username";
    private String password = "password";
    private String createTable = "CREATE TABLE todo ( " +
            "id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT, " +
            "title VARCHAR(255) NOT NULL, " +
            "name VARCHAR(100) NOT NULL, " +
            "sequence INT(1) NOT NULL, " +
            "type VARCHAR(20) DEFAULT 'TODO', " +
            "regdate DATETIME DEFAULT NOW(), " +
            "PRIMARY KEY (id) );";

    public DatabaseInitializerSample() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbUrl,user,password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTable);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
