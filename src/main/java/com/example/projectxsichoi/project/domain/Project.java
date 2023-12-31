package com.example.projectxsichoi.project.domain;

import com.example.projectxsichoi.department.domain.Department;
import com.example.projectxsichoi.employee.domain.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Project {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID")
	Long id;

	@Column(name = "CODE")
	String code;

	@Column(name = "NAME", length = 12)
	String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID")
	Department department;

	@OneToMany(mappedBy = "project")
	List<ProjectParticipation> projectParticipations = new ArrayList<>();

}
