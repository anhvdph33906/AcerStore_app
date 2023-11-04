package com.acerstore.app.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl="jdbc:sqlserver://localhost\\DESKTOP-HGOU1M7\\SQLEXPRESS:1433;databaseName=AcerStore;encrypt=true;trustServerCertificate=true;";
    private static String user="sa";
    private static String pass="123123";
     
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } 
    }
    
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException{
        Connection con = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement ps = null;
        if(sql.trim().startsWith("{")){
            ps = con.prepareCall(sql);
        }else{
            ps = con.prepareStatement(sql);
        }
        for(int i = 0; i< args.length; i++){
            ps.setObject(i + 1, args[i]);
        }
        return ps;
    }
    
    public static int update(String sql, Object... args){
        try {
            PreparedStatement ps = getStmt(sql, args);
            try {
                return ps.executeUpdate();
            } finally {
                ps.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ResultSet querry(String sql, Object... args){
        try {
            PreparedStatement ps = getStmt(sql, args);
            return ps.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Object value(String sql, Object... args){
        try {
            ResultSet rs = querry(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
