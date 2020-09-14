
package in.nareshit.aashish.service;

import java.util.List;

import in.nareshit.aashish.model.Employee;

public interface IEmployeeService {
	/**
	 * This method reads FORM data as Model Class
	 * @param e indicates ModelAttribute
	 * @return Integer as PK generated after save
	 */
	public Integer saveEmployee(Employee e);
	
	/**
	 * This method is used to fetch data from Databse using
	 * findAll() method and
	 * @return List<Employee> object back to UI
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * This method takes one @param id (PK) and
	 * performs DELETE operations at DB.
	 */
	public void deleteEmployee(Integer id);
	
	/**
	 * This method is used to read @param id as an
	 * input and @return Employee object else
	 * EmployeeNotFoundException
	 */
	public Employee getOneEmployee(Integer id);

}
