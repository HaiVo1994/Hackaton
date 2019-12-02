package com.quiz.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionQuiz {
    private static final String host= "localhost:3306/";
    private static final String databaseName = "Quiz";
    private static final String user = "root";
    private static final String password = "mysqlvophihai1994";
    private static final String urlConnection = "jdbc:mysql://" + host + databaseName;

    public static java.sql.Connection getSqlConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(urlConnection, user, password);
    }
}
