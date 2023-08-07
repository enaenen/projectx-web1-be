package com.example.projectxsichoi.employee.service;

import com.example.projectxsichoi.employee.domain.Employee;
import com.example.projectxsichoi.employee.dto.EmployeeCreateUpdateDto;
import com.example.projectxsichoi.employee.repository.EmployeeRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public Employee createEmployee(EmployeeCreateUpdateDto dto) {
		Employee employee = Employee.of(dto.getPhoneNumber(), dto.getSalary(), dto.getFirstName(),
				dto.getLastName());
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	public List<Employee> findAllEmployees(Long departmentId) {
		return employeeRepository.findAllByDepartmentId(departmentId);
	}
}
