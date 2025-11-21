package com.employee.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailsDTO {
	
	@NotBlank(message = "Employee Should not contains Space at Starting")
	@Pattern(regexp = "^[A-Za-z ]+$",message = "Name Should Not Contains Digits")
	private String empname;
	@Email(message = "Invalid Email id")
	@NotBlank(message = "email should not blank")
	private String emailid;
	@NotNull(message = "Employee Salary should not be null")
	@PositiveOrZero(message = "Salary Should be 0 or more than 0")
	private Double empsalary;
	@NotNull(message = "Mobile Number should not be null")
	@Max(value = 9999999999l ,message = "Invalid")
	@Min(value = 6666666666l,message = "Invalid Mb")
	private Long mobilenumber;
	@NotNull(message = "Not Be null")
	@PositiveOrZero(message = "DEPTNO Should be 0 or more than 0")
	private Integer deptno;
	@NotBlank(message = "Gender Should Not be null")
	private String gender;
	@NotBlank(message = "Address Should Not be null")
	private String address;

}
