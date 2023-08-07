package com.example.projectxsichoi.project.domain;

import com.example.projectxsichoi.employee.domain.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PROJECT_PARTICIPATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ProjectParticipation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	@Column(name = "JOINED_AT", nullable = false)
	private LocalDateTime joinedAt;

}
