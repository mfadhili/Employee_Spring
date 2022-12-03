package com.mfadhili.employee_app.data.repository;
/**
 * Employee Repository extends the generic JpaRepository.
 * The Jpa Repository has some generic methods that can be inherited by extending it.
 * @Repository makes the interface a bean i.e A java class tha Springboot knows of
 * */

import com.mfadhili.employee_app.data.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
}
