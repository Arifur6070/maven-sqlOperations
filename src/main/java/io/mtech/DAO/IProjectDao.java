package io.mtech.DAO;

import io.mtech.model.Project;

public interface IProjectDao {
	public boolean addProject(Project p)throws Exception;
	public boolean deleteProject(int id)throws Exception;
	public boolean updateProject(int id, Project p)throws Exception;
	//public Project findProjectById(int id)throws Exception;
	public Project findProjectById(int id) throws Exception;

}
