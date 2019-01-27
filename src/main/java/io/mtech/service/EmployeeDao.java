package io.mtech.service;

import io.mtech.DAO.IEmployeeDao;
import io.mtech.dbUtil.DBOperation;
import io.mtech.model.Employee;

public class EmployeeDao implements IEmployeeDao{

	public boolean addEmployee(Employee e) throws Exception {
		DBOperation dO = new DBOperation();
		boolean inserted = dO.insert(e);
		return inserted;
	}

	public boolean deleteEmployee(int id) throws Exception {
		DBOperation dO = new DBOperation();
		boolean deleted = dO.delete(id);
		return deleted;
	}

	public boolean updateEmployee(int id,Employee e) throws Exception {
		DBOperation dO = new DBOperation();
		boolean deleted = dO.update(id,e);
		return deleted;
	}

	public Employee FindEmployeeById(int id)throws Exception {
		DBOperation dO = new DBOperation();
		Employee user = dO.findUser(id);
		return user;
	}

}
