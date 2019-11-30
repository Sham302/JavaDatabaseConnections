package com.spartaglobal.JavaDatabaseConnections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeesAge {
    List<String> employeeNames = new ArrayList<>();

    private NorthwindDBConnectionManager nwconn = new NorthwindDBConnectionManager();

    public List<String> getEmployeeList() {

        final String SQL = "SELECT  TOP 10 FirstName, LastName FROM Employees WHERE YEAR(GETDATE())-YEAR(BirthDate)>60 ORDER BY BirthDate DESC";
        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()) {
                employeeNames.add(resultSet.getString("FirstName") + " " + resultSet.getString("LastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeNames;
    }




}

