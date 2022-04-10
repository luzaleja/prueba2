package prueba2.service;

import java.util.List;

import prueba2.domain.Employee;
import prueba2.exceptions.ServiceException;

public interface EmployeeService {
	
	public Employee create(Employee employee) throws ServiceException;
	
	public Employee read(Long id) throws ServiceException;
	
	public List<Employee> readAll() throws ServiceException;
	
	public Employee getBossById(Long id) throws ServiceException;

}
