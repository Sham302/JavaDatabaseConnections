package com.spartaglobal.JavaDatabaseConnections;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class EmployeeTitleTest {


    @Test
    public void EmployeeTest() {
        EmployeeTitle employeeTitle = new EmployeeTitle();

        Map<String, Integer> output = Map.ofEntries();

        Map.entry("Vice President, Sales", 1);
        Map.entry("Sales Representative", 6);
        Map.entry("Inside Sales Coordinator", 1);
        Map.entry("Sales Manager", 1);
        Assert.assertEquals(output, employeeTitle.getEmployeeTitle());
    }
}