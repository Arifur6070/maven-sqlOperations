package io.mtech.model;

public class Project {
	private int projectId;
	private String projectName;
	private int empId;
	
	
	public Project() {
		super();
	}
	public Project(int id,String projectName, int empId) {
		super();
		this.projectId=id;
		this.projectName = projectName;
		this.empId = empId;
	}
//	public Project(int projectId, String projectName, int empId) {
//		super();
//		this.projectId = projectId;
//		this.projectName = projectName;
//		this.empId = empId;
//	}
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	

}
