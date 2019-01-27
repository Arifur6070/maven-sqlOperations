package com.romi.DB.maveb_Db;


import java.sql.SQLException;
import java.util.List;

import io.mtech.dbUtil.JoinOperation;
import io.mtech.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        
        JoinOperation jo = new JoinOperation();
        List<Employee> li = jo.columnAliases();
        
        for(int i =0; i<li.size();i++)
        {
        	System.out.println(li.get(i));
        }
    }
}
