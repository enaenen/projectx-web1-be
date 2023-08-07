package com.example.projectxsichoi.employee.domain;

import com.example.projectxsichoi.department.domain.Department;
import com.example.projectxsichoi.department.domain.DepartmentLocation;
import com.example.projectxsichoi.project.domain.Project;
import com.example.projectxsichoi.project.domain.ProjectParticipation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
@Entity
@Table(name = "EMPLOYEE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	Long id;

	@Column(name = "PHONE_NUMBER", length = 32, nullable = false)
	String phoneNumber;

	@Column(name = "SALARY", length = 32, nullable = false)
	Integer salary;

	@Column(name = "FIRST_NAME", nullable = false)
	String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	String lastName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID")
	Department department;

	@OneToMany(mappedBy = "employee")
	private List<ProjectParticipation> projectParticipations = new ArrayList<>();


	protected Employee(String phoneNumber, Integer salary, String firstName, String lastName) {
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public static Employee of(String phoneNumber, Integer salary, String firstName,
			String lastName) {
		Employee employee = new Employee(phoneNumber, salary, firstName, lastName);
		if (!employee.isValid()) {
			throw new IllegalArgumentException("isValid False");
		}
		return employee;
	}

	private boolean isValid() {
		if (!StringUtils.hasText(phoneNumber)) {
			log.error("Invalid phone number");
			return false;
		}
		if (salary == null || salary < 1) {
			log.error("Invalid salary");
			return false;
		}
		if (!StringUtils.hasText(this.firstName)) {
			log.error("Invalid first name");
			return false;
		}
		if (!StringUtils.hasText(this.lastName)) {
			log.error("Invalid last name");
			return false;
		}
		return true;
	}

}
