package io.mtech.dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import io.mtech.model.Employee;

public class JoinOperation {
	static Logger log = Logger.getLogger(DBOperation.class.getName());
	
	public List<Employee> innerJoin() throws SQLException
	{
		Connection con = DBConnection.getConnection();
		//Connection con = DBConnection.getConnection();
		try {
		log.info(con.getCatalog());
		
		PreparedStatement ps = con.prepareStatement("SELECT Arifur_EmployeeList.ID,Arifur_EmployeeList.EmpName, Arifur_Project.projectId ,Arifur_Project.projectName FROM Arifur_EmployeeList INNER JOIN Arifur_Project ON Arifur_EmployeeList.ID=Arifur_Project.eId;");
		
		ResultSet resultSet=ps.executeQuery();
		
		List <Employee> empList = new ArrayList<Employee>();
		
		while(resultSet.next())
		{
			Employee emp = new Employee();
			emp.setId(resultSet.getInt("ID"));
			emp.setName(resultSet.getString("EmpName"));
			emp.setDepartment(resultSet.getString("Department"));
			emp.setProjectId(resultSet.getInt("projectId"));
			emp.setSalary(resultSet.getInt("Salary"));
			emp.setProjectName(resultSet.getString("projectName"));
			
			
			empList.add(emp);
			
			
		}
		
		return empList;
		}
	    catch(Exception e)
		{
			log.info(e.getMessage());
		}
		
		
		return null;
		
		
		
	}
	public List<Employee> leftJoin() throws SQLException
	{
		Connection con = DBConnection.getConnection();
		//Connection con = DBConnection.getConnection();
		try {
		log.info(con.getCatalog());
		
		PreparedStatement ps = con.prepareStatement(" SELECT*\r\n" + 
        		"FROM Arifur_EmployeeList\r\n" + 
        		"LEFT JOIN Arifur_Project ON Arifur_EmployeeList.ID = Arifur_Project.eId\r\n" + 
        		"ORDER BY Arifur_EmployeeList.EmpName;");
		
		ResultSet resultSet=ps.executeQuery();
		
		List <Employee> empList = new ArrayList<Employee>();
		
		while(resultSet.next())
		{
			Employee emp = new Employee();
			emp.setId(resultSet.getInt("ID"));
			emp.setName(resultSet.getString("EmpName"));
			emp.setDepartment(resultSet.getString("Department"));
			emp.setProjectId(resultSet.getInt("projectId"));
			emp.setSalary(resultSet.getInt("Salary"));
			emp.setProjectName(resultSet.getString("projectName"));
			
			
			empList.add(emp);
			
			
		}
		
		return empList;
		}
	    catch(Exception e)
		{
			log.info(e.getMessage());
		}
		
		
		return null;
		
		
		
	}
	
	public List<Employee> rightJoin() throws SQLException
	{
		Connection con = DBConnection.getConnection();
		//Connection con = DBConnection.getConnection();
		try {
		log.info(con.getCatalog());
		
		PreparedStatement ps = con.prepareStatement(" SELECT*\r\n" + 
        		"FROM Arifur_EmployeeList\r\n" + 
        		"RIGHT JOIN Arifur_Project ON Arifur_EmployeeList.ID = Arifur_Project.eId\r\n" + 
        		"ORDER BY Arifur_EmployeeList.EmpName;");
		
		ResultSet resultSet=ps.executeQuery();
		
		List <Employee> empList = new ArrayList<Employee>();
		
		while(resultSet.next())
		{
			Employee emp = new Employee();
			emp.setId(resultSet.getInt("ID"));
			emp.setName(resultSet.getString("EmpName"));
			emp.setDepartment(resultSet.getString("Department"));
			emp.setProjectId(resultSet.getInt("projectId"));
			emp.setSalary(resultSet.getInt("Salary"));
			emp.setProjectName(resultSet.getString("projectName"));
			
			empList.add(emp);
			
			
		}
		
		return empList;
		}
	    catch(Exception e)
		{
			log.info(e.getMessage());
		}
		
		
		return null;
		
		
		
	}
	
	public List<Employee>fullJoin() throws SQLException
	{
		Connection con = DBConnection.getConnection();
		//Connection con = DBConnection.getConnection();
		try {
		log.info(con.getCatalog());
		
		PreparedStatement ps = con.prepareStatement(" SELECT*\r\n" + 
        		"FROM Arifur_EmployeeList\r\n" + 
        		"FULL JOIN Arifur_Project ON Arifur_EmployeeList.ID = Arifur_Project.eId\r\n" + 
        		"ORDER BY Arifur_EmployeeList.EmpName;");
		
		ResultSet resultSet=ps.executeQuery();
		
		List <Employee> empList = new ArrayList<Employee>();
		
		while(resultSet.next())
		{
			Employee emp = new Employee();
			emp.setId(resultSet.getInt("ID"));
			emp.setName(resultSet.getString("EmpName"));
			emp.setDepartment(resultSet.getString("Department"));
			emp.setProjectId(resultSet.getInt("projectId"));
			emp.setSalary(resultSet.getInt("Salary"));
			emp.setProjectName(resultSet.getString("projectName"));
			
			
			empList.add(emp);
			
			
		}
		
		return empList;
		}
	    catch(Exception e)
		{
			log.info(e.getMessage());
		}
		
		
		return null;
		
		
		
	}
	
	public List<Employee> maxSalary()
	{
		Connection con = DBConnection.getConnection();
		try {
			log.info(con.getCatalog());
			
			PreparedStatement ps = con.prepareStatement("SELECT MAX(Salary),Department FROM Arifur_EmployeeList GROUP BY Department");
			ResultSet resultSet = ps.executeQuery();
			
			List <Employee> empList = new ArrayList<Employee>();
			while(resultSet.next())
			{
				Employee emp = new Employee();
				//emp.setId(resultSet.getInt("ID"));
				//emp.setName(resultSet.getString("EmpName"));
				emp.setDepartment(resultSet.getString("Department"));
				//emp.setProjectId(resultSet.getInt("projectId"));
				//emp.setSalary(resultSet.getInt("Salary"));
				//emp.setProjectName(resultSet.getString("projectName"));
				
				
				
				empList.add(emp);
				
				
			}
			return empList;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Employee> minSalary()
	{
		Connection con = DBConnection.getConnection();
		try {
			log.info(con.getCatalog());
			
			PreparedStatement ps = con.prepareStatement("SELECT MIN(Salary),Department FROM Arifur_EmployeeList GROUP BY Department");
			ResultSet resultSet = ps.executeQuery();
			
			List <Employee> empList = new ArrayList<Employee>();
			while(resultSet.next())
			{
				Employee emp = new Employee();
				//emp.setId(resultSet.getInt("ID"));
				//emp.setName(resultSet.getString("EmpName"));
				emp.setDepartment(resultSet.getString("Department"));
				//emp.setProjectId(resultSet.getInt("projectId"));
				//emp.setSalary(resultSet.getInt("Salary"));
				//emp.setProjectName(resultSet.getString("projectName"));
				
				
				
				empList.add(emp);
				
				
			}
			return empList;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Employee> columnAliases()
	{
		Connection con = DBConnection.getConnection();
		try {
			log.info(con.getCatalog());
			
			PreparedStatement ps = con.prepareStatement(" SELECT ID AS EmployeeID, EmpName AS Name,Department AS Dept FROM Arifur_EmployeeList");
			ResultSet resultSet = ps.executeQuery();
			
			List <Employee> empList = new ArrayList<Employee>();
			while(resultSet.next())
			{
				Employee emp = new Employee();
				emp.setId(resultSet.getInt("EmployeeID"));
				emp.setName(resultSet.getString("Name"));
				emp.setDepartment(resultSet.getString("Dept"));
				//emp.setProjectId(resultSet.getInt("projectId"));
				//emp.setSalary(resultSet.getInt("Salary"));
				//emp.setProjectName(resultSet.getString("projectName"));
				
				
				
				empList.add(emp);
				
				
			}
			return empList;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	
	

}
