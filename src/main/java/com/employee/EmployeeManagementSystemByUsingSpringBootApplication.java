package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@springBootApplication is the combination of  ===> @SpringBootConfiguration ,@EnableAutoConfiguration,@ComponenetScan<====
 * it is used to run the Spring Boot project
 * It is used to Enable Auto Configuration
 * It is used to enable Spring boot Configuration
 * it is used to show the path of component classes 
 *  */


@SpringBootApplication
public class EmployeeManagementSystemByUsingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemByUsingSpringBootApplication.class, args);
	}

}
