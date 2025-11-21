package com.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.EmployeeManagementSystemByUsingSpringBootApplication;
import com.employee.DTO.EmployeeDetailsDTO;
import com.employee.entity.EmployeeDetails;
import com.employee.exception.EmployeeExceptionHandler;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	private final EmployeeManagementSystemByUsingSpringBootApplication employeeManagementSystemByUsingSpringBootApplication;

	private final EmployeeExceptionHandler employeeExceptionHandler;
	@Autowired
	EmployeeService employeeService;

	EmployeeController(EmployeeExceptionHandler employeeExceptionHandler,
			EmployeeManagementSystemByUsingSpringBootApplication employeeManagementSystemByUsingSpringBootApplication,
			EmployeeRepository employeeRepository) {
		this.employeeExceptionHandler = employeeExceptionHandler;
		this.employeeManagementSystemByUsingSpringBootApplication = employeeManagementSystemByUsingSpringBootApplication;
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping("/registrationpage")
	public String employeeRegistrationPage(Model model) {
		model.addAttribute("employeeDetails", new EmployeeDetailsDTO());
		return "EmployeeRegistration";
	}

	@RequestMapping("/registration")
	public String employeeRegistration(@Valid EmployeeDetailsDTO employeeDetailsdto) {
		System.out.println(employeeDetailsdto);
		employeeService.employeeRegistration(employeeDetailsdto);
		return "redirect:/getAllEmployeeDetails";

	}

	@RequestMapping("/getAllEmployeeDetails")
	public String getAllEmployeeDetails(Model model) {
		List<EmployeeDetails> allEmployeeDetails = employeeService.getEmployeeDetails();
		System.out.println(allEmployeeDetails);
		model.addAttribute("listofemployeedetails", allEmployeeDetails);
		return "DisplayAllEmployeeDetails";

	}

	@RequestMapping("/deletebyid")
	public String deleteEmployeeDetailsById(int empid) {
		System.out.println(empid);
		employeeService.deleteEmployeeDetailsById(empid);
		return "redirect:/getAllEmployeeDetails";
	}

	@RequestMapping("/getbyid")
	public String getEmployeeDetailsById(int empid, Model model) {
		System.out.println(empid);
		EmployeeDetails employeeDetails = employeeService.getEmployeeDetailsById(empid);
		System.out.println(employeeDetails);
		model.addAttribute("employeeDetails", employeeDetails);
		return "UpdateEmployeeDetails";

	}
	@RequestMapping("/updateemployeedetails")
	public String updateEmployeeDetails(EmployeeDetails employeeDetails)
	{
		int deltails=employeeService.updateEmployeeDetailsById(employeeDetails);
		System.out.println(employeeDetails);
		return "redirect:/getAllEmployeeDetails";
	}
	@RequestMapping("/filterby")
	public String filterEmployeeDetails(String filterdata ,Model model)
	{
		System.out.println(filterdata);
		List<EmployeeDetails> filterEmployeeDetails=
				employeeService.filterEmployeeDetails(filterdata);
		model.addAttribute("listofemployeedetails", filterEmployeeDetails);
		return "DisplayAllEmployeeDetails";
		
	}
	

}
