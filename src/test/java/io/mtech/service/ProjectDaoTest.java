package io.mtech.service;

import static org.junit.Assert.*;

import org.junit.Test;

import io.mtech.model.Project;

public class ProjectDaoTest {

	@Test
	public void testAddProject() throws Exception {
		ProjectDao pd = new ProjectDao();
		//Project p = new Project("Web POS",5);
		
		//assertEquals(true, pd.addProject(p));
		
	}

	@Test
	public void testDeleteProject() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProject() throws Exception {
		ProjectDao pd = new ProjectDao();
		Project p = new Project(1,"Web POS",5);
		assertEquals(true, pd.updateProject(1, p));
		
		
	}

	@Test
	public void testFindProjectById() {
		fail("Not yet implemented");
	}

}
