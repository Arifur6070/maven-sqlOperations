package io.mtech.service;

import io.mtech.DAO.IProjectDao;
import io.mtech.dbUtil.ProjectDBOperation;
import io.mtech.model.Project;

public class ProjectDao implements IProjectDao{

	public boolean addProject(Project p) throws Exception {
		ProjectDBOperation pdb = new ProjectDBOperation();
		boolean inserted = pdb.insertProject(p);
		return inserted;
		
	}

	public boolean deleteProject(int id) throws Exception {
		
		ProjectDBOperation pdb = new ProjectDBOperation();
		boolean deleted = pdb.deleteProject(id);
		return deleted;
	}

	public boolean updateProject(int id, Project p) throws Exception {
		ProjectDBOperation pdb = new ProjectDBOperation();
		boolean updated = pdb.updateProject(id, p);
		return updated;
	}

	public Project findProjectById(int id) throws Exception {
		ProjectDBOperation pdb = new ProjectDBOperation();
		Project p  = pdb.findUser(id);
		return p;
	}



	

}
