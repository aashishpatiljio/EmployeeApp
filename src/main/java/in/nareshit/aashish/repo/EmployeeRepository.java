package in.nareshit.aashish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.aashish.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
