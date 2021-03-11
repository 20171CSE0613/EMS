package com.cg.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.entities.Employee;
import com.cg.ems.repository.IEmployeeRepository;

import com.cg.ems.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements IEmployeeService  {

	@Autowired
	private IEmployeeRepository edao;

	//add employee 
	@Override
	public Employee addEmployee(Employee emp) {
		edao.save(emp);
		return emp;
	}

	//delete employee
	@Override
	public void deleteEmployee(Integer eUserId){
		Optional<Employee> emp = edao.findById(eUserId);
		if (emp.isPresent()) {
			Employee e = emp.get();
			edao.delete(e);		
		}
		else {
			throw new EmployeeNotFoundException("Customer with id " +eUserId +" not found");
		}
	}

	//update employee
	@Override
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> existing = Optional.of(edao.findById(emp.geteUserId()).get());

		if(existing.isPresent()) {
			Employee existingEmployee = edao.findById(emp.geteUserId()).get();

			existingEmployee.setFirstName(emp.getFirstName());
			existingEmployee.setLastName(emp.getLastName());
			existingEmployee.setDob(emp.getDob());
			existingEmployee.setEmail(emp.getEmail());
			edao.save(existingEmployee);

			return existingEmployee;
		}
		else {
			throw new EmployeeNotFoundException("Customer does not exist");
		}	
	}

	//get all employee
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=edao.findAll();
		return employees;
	}


	//get employee by id
	@Override
	public Employee getEmployeeById(Integer eUserId) {
		Optional<Employee> optional=edao.findById(eUserId);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}
		else {
			throw new EmployeeNotFoundException("Employee not found");
		}
		return employee;
	}

	//get employee by pagination
	@Override
	public List<Employee> getAllEmployeesByPagination(String maxPage, String ofset) {

		return null;
	}

	//get employee count
	@Override
	public int getEmployeeCount() {
		int count = (int) edao.count();
		return count;	
	}


}