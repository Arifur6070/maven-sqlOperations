package io.mtech.dbUtil;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;

import io.mtech.model.Employee;

public class DBOperation {
	
	static Logger log = Logger.getLogger(DBOperation.class.getName());
    
	
	public boolean insert(Employee e) throws Exception {
		
		
		
		Connection con = DBConnection.getConnection();
		
		log.info(con.getCatalog());
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO dbo.Arifur_EmployeeList(EmpID,EmpName,Department,Salary) VALUES (?,?,?,?)");
		ps.setString(1, e.getEmployeeId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getDepartment());
		ps.setInt(4, e.getSalary());
		
		int resultSet=ps.executeUpdate();
		
		log.info("Employee inserted!");
		
		if(resultSet==1)
		{
			con.close();
			return true;
		}
		else
		{
			con.close();
			return false;
		}
	
		
	}
	
	
	public boolean delete(int id) throws Exception {
		Connection con = DBConnection.getConnection();
		
		log.info(con.getCatalog());
		
		PreparedStatement ps = con.prepareStatement("DELETE FROM dbo.Arifur_EmployeeList WHERE ID=" + id);
		int resultSet=ps.executeUpdate();
		
		log.info("Employee deleted!");
		
		if(resultSet==1)
		{
			con.close();
			return true;
		}
		else
		{
			con.close();
			return false;
		}
	
		
	}
	
	public boolean update(int id,Employee e) throws Exception {
		Connection con = DBConnection.getConnection();
		
		log.info(con.getCatalog());
		try {
		PreparedStatement ps = con.prepareStatement("UPDATE dbo.Arifur_EmployeeList SET EmpID =?,EmpName =?,Department =?,salary =? WHERE ID=?");
		
		ps.setString(1, e.getEmployeeId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getDepartment());
		ps.setInt(4, e.getSalary());
		ps.setInt(5, id);
		
		int resultSet=ps.executeUpdate();
		
		log.info("Employee updated!");
		
		if(resultSet==1)
		{
			con.close();
			return true;
		}
		}catch(Exception ex)
		{
			log.info(ex.getMessage());
		}
			return false;
		}
	
		


public Employee findUser(int id) throws Exception {
	
	Connection con = DBConnection.getConnection();
	log.info(con.getCatalog());
	
	
	
	try {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM dbo.Arifur_EmployeeList WHERE ID=" + id);
		
		ResultSet rs=ps.executeQuery();
		
		log.info("Employee found!");
		
		if (rs.next()) {
			Employee user = new Employee();
			user.setEmployeeId(rs.getString("EmpID"));
			user.setName(rs.getString("EmpName"));
			user.setDepartment(rs.getString("department"));
			user.setSalary(rs.getInt("Salary"));
			return user;
		}
		}catch(Exception ex)
		{
			log.info(ex.getMessage());
		}
	
	
	return null;
	
}
}