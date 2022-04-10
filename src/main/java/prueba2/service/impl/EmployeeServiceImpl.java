package prueba2.service.impl;

import java.util.List;

import prueba2.dao.EmployeeDao;
import prueba2.dao.impl.EmployeeDaoImpl;
import prueba2.domain.Employee;
import prueba2.exceptions.GenericException;
import prueba2.exceptions.ServiceException;
import prueba2.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		this.employeeDao = new EmployeeDaoImpl();
	}
	
	@Override
	public Employee create(Employee employee) throws ServiceException {
			
		try {
			return employeeDao.create(employee);
		} catch (GenericException e) {
			throw new ServiceException("Error",e);
		}
	}

	@Override
	public Employee read(Long id) throws ServiceException {

		try {
			Employee employeeFound = employeeDao.read(id);
			Employee boss = employeeDao.read(employeeFound.getBossId());
			employeeFound.setBoss(boss);
			return employeeFound;
		} catch (GenericException e) {
			throw new ServiceException("Error",e);
		}
	}

	@Override
	public List<Employee> readAll() throws ServiceException {

		try {
			return employeeDao.readAll();
		} catch (GenericException e) {
			throw new ServiceException("Error",e);
		}
	}

	@Override
	public Employee getBossById(Long id) throws ServiceException {
		Employee boss = read(id);
		return boss;
	}

}
