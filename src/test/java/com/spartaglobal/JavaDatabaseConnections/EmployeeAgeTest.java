package com.spartaglobal.JavaDatabaseConnections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeAgeTest {
    @Test
    public void EmployeesAgeTest(){
        EmployeesAge employeesAge = new EmployeesAge();

       List<String> output = Arrays.asList("Laura Callahan","Steven Buchanan", "Andrew Fuller", "Nancy Davolio", "Margaret Peacock");
        Assert.assertEquals(output, employeesAge.getEmployeeList());
    }
}
