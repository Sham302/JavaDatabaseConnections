package com.spartaglobal.JavaDatabaseConnections;

import org.junit.Assert;
import org.junit.Test;


import java.util.HashMap;

import java.util.Map;

public class TotalEmployeesTest {
    @Test
    public void TotalEmployeeTest(){
        TotalEmployees totalEmployees = new TotalEmployees();

        Map<String,Integer> output = Map.ofEntries();
               Map.entry ("UK",4);
               Map.entry("USA",5);
        Assert.assertEquals(output, totalEmployees.numberOfEmployees);
    }
}
