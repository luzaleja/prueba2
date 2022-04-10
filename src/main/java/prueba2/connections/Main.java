package prueba2.connections;


import java.util.List;

import prueba2.domain.Employee;
import prueba2.exceptions.ServiceException;
import prueba2.service.EmployeeService;
import prueba2.service.impl.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) throws ServiceException {

		EmployeeService es = new EmployeeServiceImpl();
		
		Employee le = es.read(2l);
		List<Employee> list = es.readAll();
		System.out.println(le);
		System.out.println(list);
		
		Employee newem = new Employee("Luz","developer",1l);
		
		es.create(newem);
	}

}
