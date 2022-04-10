package prueba2.dao;

import java.util.List;

import prueba2.domain.Employee;
import prueba2.exceptions.GenericException;

public interface EmployeeDao {

	public Employee create(Employee employee) throws GenericException;
	
	public Employee read(Long id) throws GenericException;
	
	public List<Employee> readAll() throws GenericException;
}
