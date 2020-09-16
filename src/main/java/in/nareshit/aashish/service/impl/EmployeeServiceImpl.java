package in.nareshit.aashish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.aashish.exception.EmployeeNotFoundException;
import in.nareshit.aashish.model.Employee;
import in.nareshit.aashish.repo.EmployeeRepository;
import in.nareshit.aashish.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee e) {
		/*
		 * save(obj) method returns same object with id effected after save.
		 */
		return repo.save(e).getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = repo.findAll();
		list.sort((e1, e2) -> e1.getId() - e2.getId());
		return list;
	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Employee e = repo.findById(id).orElseThrow(
				() -> new EmployeeNotFoundException("EMPLOYEE '" + id + "' NOT EXIST")
				);
		return e;
	}

	@Override
	public void updateEmployee(Employee emp) {
		repo.save(emp);
	}

}
