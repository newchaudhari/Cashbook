package utils;

import constants.DBConstants;

import java.sql.*;

public class DBUtils {
    public static Connection connection = null;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(DBConstants.DB_url, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("not connecting " + e.getMessage());
        }
        return connection;
    }

}
