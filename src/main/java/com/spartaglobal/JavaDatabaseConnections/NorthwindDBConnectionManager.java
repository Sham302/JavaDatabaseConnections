package com.spartaglobal.JavaDatabaseConnections;

import com.spartaglobal.PropertiesManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NorthwindDBConnectionManager {
    private PropertiesManager props = new PropertiesManager();
    private final String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;databaseName=northwind;user="+ props.getUserName() +";password=" + props.getPassword();

   public Connection northwindConnection() throws SQLException{
       return DriverManager.getConnection(CONNECTIONURL);
   }
}


