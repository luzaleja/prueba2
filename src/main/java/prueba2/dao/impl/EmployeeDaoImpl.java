package prueba2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prueba2.connections.ConnectionAdmin;
import prueba2.dao.EmployeeDao;
import prueba2.domain.Employee;
import prueba2.exceptions.GenericException;
import prueba2.utils.DTOUtils;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee create(Employee employee) throws GenericException {

		String sql = "INSERT INTO employee (fullname,functions,boss_id) VALUES (?,?,?)";
		
		try (Connection con = ConnectionAdmin.tryConnection();){
			
			try (PreparedStatement st = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				st.setString(1,employee.getFullname());
				st.setString(2, employee.getFunctions());
				st.setLong(3, employee.getBossId());
				st.execute();
				
				try (ResultSet res = st.getGeneratedKeys()) {

					if(res.next()) {
						Long lastGeneratedId = res.getLong(1);
						employee.setId(lastGeneratedId);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql,e);
		}
		return employee;
	}

	@Override
	public Employee read(Long id) throws GenericException {
		
		Employee entity = null;
		
		String sql = "SELECT * FROM employee WHERE ID = " + id;
		
		List<Employee> list = this.findBySQL(sql);
			
		if(!list.isEmpty()) {
			entity = list.get(0);
		}
		
		return entity;
	}

	@Override
	public List<Employee> readAll() throws GenericException {
		
		String sql = "SELECT * FROM employee";
		
		List<Employee> employees = this.findBySQL(sql);
		
		return employees;
	}
	
	public List<Employee> findBySQL(String whereSQL) throws GenericException {
		
		List<Employee> entity = new ArrayList<>();
		
		try (Connection con = ConnectionAdmin.tryConnection();){
			
			try (Statement st = con.createStatement()) {
				
				try (ResultSet res = st.executeQuery(whereSQL)) {

					entity = DTOUtils.populateDTOs(Employee.class, res);
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + whereSQL,e);
		}
		return entity;
	}

}
