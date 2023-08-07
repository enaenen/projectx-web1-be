package com.example.projectxsichoi.department.domain;


import com.example.projectxsichoi.employee.domain.Employee;
import com.example.projectxsichoi.project.domain.Project;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Entity
@Slf4j
@Table(name = "DEPARTMENT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department {

	@Id
	@Column(name = "DEPARTMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "CODE", nullable = false)
	private Integer code;

	@Column(name = "NAME", length = 32, nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", length = 128, nullable = false)
	private String description;

	@OneToMany(mappedBy = "department")
	private List<Employee> employees = new ArrayList<>();

	@OneToMany(mappedBy = "department")
	private List<DepartmentLocation> departmentLocation = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY)
	private List<Project> projects = new ArrayList<>();


	protected Department(String name, Integer code, String description) {
		this.name = name;
		this.code = code;
		this.description = description;
	}

	public static Department of(String name, Integer code, String description) {
		Department department = new Department(name, code, description);
		if (!department.isValid()) {
			throw new IllegalArgumentException("isValid FALSE");
		}
		return department;
	}

	private boolean isValid() {
		if (!StringUtils.hasText(this.name)) {
			log.error("Invalid name");
			return false;
		}
		if (this.code == null || this.code == 0) {
			log.error(" Invalid Code");
			return false;
		}
		if (!StringUtils.hasText(this.description)) {
			log.error("Invalid Description");
			return false;
		}
		return true;
	}


}
