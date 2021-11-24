package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String dbURL = "jdbc:mysql://localhost:3306/javapp";
    private static final String dbUserName = "root";
    private static final String dbPassword = "root";

    public static java.sql.Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
