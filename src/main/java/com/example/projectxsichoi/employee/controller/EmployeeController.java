package com.example.projectxsichoi.employee.controller;

import com.example.projectxsichoi.employee.domain.Employee;
import com.example.projectxsichoi.employee.dto.EmployeeCreateUpdateDto;
import com.example.projectxsichoi.employee.service.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1/employees/")
public class EmployeeController {
	private final EmployeeService employeeService;


	@PostMapping("{departmentId}")
	public Employee createEmployee(@PathVariable(value = "departmentId", required = true) Long departmentId, EmployeeCreateUpdateDto dto){
		log.info("log");
		return employeeService.createEmployee(dto);
	}
	@GetMapping("{departmentId}")
	public List<Employee> findAllEmployees(@PathVariable Long departmentId){
		return employeeService.findAllEmployees(departmentId);
	}


}
