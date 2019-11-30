package com.spartaglobal.JavaDatabaseConnections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class EmployeeTitle {
    Map<String,Integer> employeeTitle = new HashMap<>();

    private NorthwindDBConnectionManager nwconn = new NorthwindDBConnectionManager();

    public Map<String, Integer> getEmployeeTitle() {

        final String SQL = "SELECT Title, COUNT(Title) AS 'Employee title number'\n" +
                "FROM Employees\n" +
                "GROUP BY Title\n";
        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()) {
                employeeTitle.put((resultSet.getString("Title")) , resultSet.getInt("Employee title number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeTitle;
    }
}
