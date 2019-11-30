package com.spartaglobal.JavaDatabaseConnections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class TotalEmployees {
    Map<String, Integer> numberOfEmployees = new HashMap<String, Integer>();

    private NorthwindDBConnectionManager nwconn = new NorthwindDBConnectionManager();

    public Map<String, Integer> getTotalEmployeeList() {

        final String SQL = "SELECT Country, COUNT(Country) AS 'Employees per Country'\n" +
                "FROM Employees\n" +
                "GROUP BY Country\n";
        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);

            while (resultSet.next()) {
                numberOfEmployees.put((resultSet.getString("Country")) , resultSet.getInt("Employees per Country"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numberOfEmployees;
    }

}
