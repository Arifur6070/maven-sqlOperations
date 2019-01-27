package io.mtech.service;

import static org.junit.Assert.*;

import org.junit.Test;

import io.mtech.model.Employee;

public class EmployeeDaoTest {

	@Test
	public void testAddEmployee() throws Exception {
		Employee e3 = new Employee("112233","Any","Web Dev",40000);
		EmployeeDao ed = new EmployeeDao();
		boolean res = ed.addEmployee(e3);
		assertEquals(true, res);
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		EmployeeDao ed = new EmployeeDao();
		boolean res = ed.deleteEmployee(7);
		assertEquals(true, res);
	}

	@Test
	public void testUpdateEmployee() throws Exception {
		EmployeeDao ed = new EmployeeDao();
		Employee e = new Employee("23456","Rakibur","sales",40000);
		boolean res = ed.updateEmployee(2,e);
		assertEquals(true, res);
	}

	@Test
	public void testFindEmployeeById()throws Exception{
		EmployeeDao ed = new EmployeeDao();
		 
		 Employee e = ed.FindEmployeeById(2);
		assertNotNull(e);
	}

}
