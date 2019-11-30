package com.spartaglobal.JavaDatabaseConnections;

import com.spartaglobal.PropertiesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//sql queries should sit within methods
public class NWEmployeesDAO {

    private final String SQL = "SELECT TOP 10 * FROM Employees";
    private NorthwindDBConnectionManager nwconn = new NorthwindDBConnectionManager();

    public void iterateThroughEmployees(){
        try(Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()){
                System.out.println(resultSet.getString("firstName") + " " + resultSet.getString("lastName") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getEmployeeList() {
        final String SQL = "SELECT firstName, lastName FROM Employees";
        List<String> employeeNames = new ArrayList<>();

        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()) {
                employeeNames.add(resultSet.getString("firstName") + " " + resultSet.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeNames;
    }


    public int getTotalNumOfEmplyees(){
        return getEmployeeList().size();
    }


    public int getTotalNumberOfEmployeesV1(){
        int employeeNum = 0;
        final String SQL = "SELECT COUNT * AS 'Total' FROM Employees";
        try(Statement stmt = nwconn.northwindConnection().createStatement()){
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()){
                employeeNum = resultSet.getInt("Total");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employeeNum;
    }


}
