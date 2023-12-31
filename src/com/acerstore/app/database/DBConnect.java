package com.acerstore.app.database;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

public class DBConnect {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
<<<<<<< HEAD
    private static String dburl="jdbc:sqlserver://localhost\\sieu-ngau-09\\SQLEXPRESS:1433;databaseName=AcerStore;encrypt=true;trustServerCertificate=true;";
=======
    private static String dburl="jdbc:sqlserver://localhost\\sieu-ngau-09\\SQLEXPRESS:1433;databaseName=AcerStores;encrypt=true;trustServerCertificate=true;";
>>>>>>> c022217510cf5c213003578847bab7db6e2ce0dd
    private static String user="sa";
    private static String pass="28052004";
     
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } 
    }
    
    public static PreparedStatement preparedStatement(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = conn.prepareCall(sql); //proc
        } else {
            pstmt = conn.prepareStatement(sql); //SQL
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement pstmt = preparedStatement(sql, args);
            try {
                return pstmt.executeQuery();
            } finally {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement pstmt = preparedStatement(sql, args);
            try {
                pstmt.executeUpdate();
            } finally {
                pstmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}