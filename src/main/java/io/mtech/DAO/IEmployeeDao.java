package io.mtech.DAO;

import io.mtech.model.Employee;

public interface IEmployeeDao {
	public boolean addEmployee(Employee e) throws Exception;
	public boolean deleteEmployee(int id) throws Exception;
	public boolean updateEmployee(int id,Employee e) throws Exception;
	public Employee FindEmployeeById(int id)throws Exception;

}
