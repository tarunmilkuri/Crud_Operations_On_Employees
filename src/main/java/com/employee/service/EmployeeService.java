package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.DTO.EmployeeDetailsDTO;
import com.employee.dao.EmployeeDAO;
import com.employee.entity.EmployeeDetails;
//used for structure of the responce
@Service
public class EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	public void employeeRegistration(EmployeeDetailsDTO employeeDetailsDTO) {

		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setEmpname(employeeDetailsDTO.getEmpname());
		employeeDetails.setAddress(employeeDetailsDTO.getAddress());
		employeeDetails.setDeptno(employeeDetailsDTO.getDeptno());
		employeeDetails.setEmailid(employeeDetailsDTO.getEmailid());
		employeeDetails.setGender(employeeDetailsDTO.getGender());
		employeeDetails.setMobilenumber(employeeDetailsDTO.getMobilenumber());
		employeeDetails.setEmpsalary(employeeDetailsDTO.getEmpsalary());
		employeeDAO.insertEmployeeDetails(employeeDetails);

	}

	public List<EmployeeDetails> getEmployeeDetails() {
		List<EmployeeDetails> allEmployeeDetails = employeeDAO.selectAllEmployeeDetails();
		if (allEmployeeDetails.isEmpty()) {
			return null;
		} else {
			return allEmployeeDetails;
		}
	}
	public boolean deleteEmployeeDetailsById(int empid)
	{
		return employeeDAO.deleteEmployeeDetailsById(empid);
	}
	public EmployeeDetails getEmployeeDetailsById(int empid)
	{
		return employeeDAO.selectEmployeeDetailsById(empid);
	}
	public int updateEmployeeDetailsById(EmployeeDetails employeeDetails)
	{
		return employeeDAO.updateEmployeeDetails(employeeDetails);
	}
	public List<EmployeeDetails> filterEmployeeDetails(String filterdata)
	{
		List<EmployeeDetails> list=employeeDAO.filterEmployeeDetailsByUsingNameOrEmailOrGenderOrAddress(filterdata);
		if(!list.isEmpty())
		{
			return list;
		}
		else
			//throw new ExceptionClass;
			return null;
	}


}
