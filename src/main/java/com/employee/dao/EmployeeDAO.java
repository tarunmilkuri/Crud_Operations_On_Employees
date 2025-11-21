package com.employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeDetails;
import com.employee.repository.EmployeeRepository;

/*@repository is used to specify the classes is used to perform the crud operations 
by depending on the repository and also used to create the bean for the DAO classes */

@Repository
public class EmployeeDAO {
	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeDetails insertEmployeeDetails(EmployeeDetails employeeDetails) {
		EmployeeDetails save = employeeRepository.save(employeeDetails);
		return save;
	}

	public List<EmployeeDetails> selectAllEmployeeDetails() {
		return employeeRepository.findAll();
	}

	public boolean deleteEmployeeDetailsById(int empid) {
		employeeRepository.deleteById(empid);
		return true;
	}

	public EmployeeDetails selectEmployeeDetailsById(int empid) {
		EmployeeDetails employeeDetails = employeeRepository.findById(empid).get();
		return employeeDetails;

		/*
		 * EmployeeDetails employeeDetails=employeeRepository.findById(empid).get();
		 * return employeeDetails
		 */

	}
	public int updateEmployeeDetails(EmployeeDetails employeeDetails)
	{
		//update
		//retrn employeerepository.save(employeeDetails)
		return employeeRepository.updateEmployeeDetails(employeeDetails.getEmpname(), employeeDetails.getEmailid(), employeeDetails.getEmpsalary(), employeeDetails.getMobilenumber(), employeeDetails.getAddress(),employeeDetails.getEmpid());
	}
	public List<EmployeeDetails> filterEmployeeDetailsByUsingNameOrEmailOrGenderOrAddress(String filterdata)
	{
		return employeeRepository.getByEmpnameOrEmailidOrGenderOrAddress(filterdata,filterdata,filterdata,filterdata);
	}

}
