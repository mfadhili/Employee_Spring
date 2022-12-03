package com.mfadhili.employee_app.service;

/**
 * This interface lists all the Employee business logic, the basic CRUD and listings.
 * The @Component registers the interface as a bean in the application context and makes it accessible in classpath scanning
 *
 * */

import com.mfadhili.employee_app.data.models.Employee;
import com.mfadhili.employee_app.data.payloads.request.EmployeeRequest;
import com.mfadhili.employee_app.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmployeeService {
    MessageResponse createEmployee(EmployeeRequest employeeRequest);
    Optional<Employee> updateEmployee(Long employeeId, EmployeeRequest employeeRequest);
    void deleteEmployee(Long employeeId);
    Employee getSingleEmployee(Long employeeId);
    List<Employee> getAllEmployee();
}
