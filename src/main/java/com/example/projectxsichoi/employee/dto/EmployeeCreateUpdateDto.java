package com.example.projectxsichoi.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class EmployeeCreateUpdateDto {
	private final String firstName;
	private final String lastName;
	private final String phoneNumber;
	private final Integer salary;

}
