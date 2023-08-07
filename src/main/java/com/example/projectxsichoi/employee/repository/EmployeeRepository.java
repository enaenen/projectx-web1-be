package com.example.projectxsichoi.employee.repository;

import com.example.projectxsichoi.employee.domain.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findAllByDepartmentId(Long departmentId);
}
