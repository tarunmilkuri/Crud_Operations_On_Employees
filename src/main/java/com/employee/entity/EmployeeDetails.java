package com.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Table(name="Employee_Details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	@Column(nullable = false,name="Employee_Name")
	private String empname;
	@Column(nullable = false,unique = true ,name="Employee_Emailid")
	private String emailid;
	@Column(nullable = false,name="Employee_Salary")
	private double empsalary;
	@Column(nullable = false,unique = true,name="Employee_MobileNumber")
	private Long mobilenumber;
	@Column(nullable = false,name="Employee_DeptNo")
	private int deptno;
	@Column(nullable = false,name="Employee_Gender")
	private String gender;
	@Column(nullable = false,name="Employee_Address")
	private String address;


}
