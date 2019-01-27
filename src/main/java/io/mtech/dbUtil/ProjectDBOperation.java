package io.mtech.dbUtil;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import io.mtech.model.Project;
@Slf4j
public class ProjectDBOperation {
	
	static Logger log = Logger.getLogger(DBOperation.class.getName());
	
	public boolean insertProject(Project p) throws Exception {
		Connection con = DBConnection.getConnection();
		
		log.info(con.getCatalog());
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO dbo.Arifur_Project(projectId,projectName,eId) VALUES (?,?,?)");
		ps.setInt(1, p.getProjectId());
		ps.setString(2, p.getProjectName());
		ps.setInt(3, p.getEmpId());
		
		int resultSet=ps.executeUpdate();
		
		log.info("Project inserted!");
		
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
	
	
	public boolean deleteProject(int id) throws Exception {
		Connection con = DBConnection.getConnection();
		
		log.info(con.getCatalog());
		
		PreparedStatement ps = con.prepareStatement("DELETE FROM dbo.Arifur_Project WHERE projectId=" + id);
		int resultSet=ps.executeUpdate();
		
		log.info("Project deleted!");
		
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
	
	public boolean updateProject(int id,Project p) throws Exception {
		Connection con = DBConnection.getConnection();
		
		log.info(con.getCatalog());
		try {
		PreparedStatement ps = con.prepareStatement("UPDATE dbo.Arifur_Project SET projectName =?,eId=? WHERE projectId=?");
		
		ps.setString(1, p.getProjectName());
		ps.setInt(2, p.getEmpId());
		ps.setInt(3, id);
		
		int resultSet=ps.executeUpdate();
		
		log.info("Project updated!");
		
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
	
		


public Project findUser(int id) throws Exception {
	
	Connection con = DBConnection.getConnection();
	log.info(con.getCatalog());
	
	
	
	try {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM dbo.Arifur_Project WHERE ID=" + id);
		
		ResultSet rs=ps.executeQuery();
		
		log.info("Project found!");
		
		if (rs.next()) {
			Project p = new Project();
			//user.setEmployeeId(rs.getString("EmpID"));
			p.setProjectName(rs.getString("prejectName"));
			p.setEmpId(rs.getInt("eId"));
			return p;
		}
		}catch(Exception ex)
		{
			log.info(ex.getMessage());
		}
	
	
	return null;
	
}
}