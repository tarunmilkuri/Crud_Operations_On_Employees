package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.employee.entity.EmployeeDetails;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {
	int deleteByEmpid(int empid);

	@Modifying
	@Transactional
	@Query("UPDATE EmployeeDetails emp SET  emp.empname = ?1,emp.emailid = ?2,emp.empsalary = ?3, emp.mobilenumber = ?4,emp.address = ?5 WHERE emp.empid = ?6")
	int updateEmployeeDetails(String name, String emailid, Double salary, Long mobilenumber, String address,Integer empid);

	List<EmployeeDetails> getByEmpnameOrEmailidOrGenderOrAddress(String empname, String emailid, String gender,
			String address);

}
