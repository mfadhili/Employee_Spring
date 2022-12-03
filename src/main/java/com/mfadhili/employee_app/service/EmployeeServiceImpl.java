package com.mfadhili.employee_app.service;

/**
 *  A class that implements the Employee service.
 *  This class implements the Employee service by overriding the methods and implementing them
 * */

import com.mfadhili.employee_app.data.models.Employee;
import com.mfadhili.employee_app.data.payloads.request.EmployeeRequest;
import com.mfadhili.employee_app.data.payloads.response.MessageResponse;
import com.mfadhili.employee_app.data.repository.EmployeeRepository;
import com.mfadhili.employee_app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service /**collections of library methods that manage one aspect og an application logic */
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    /** to perform field dependency injection.
     *It injects EmployeeRepository interface  which is the dependent bean into the Impl class so that it can be used
     * It is also made possible by rhe @Repository annotation that makes it a bean
     * */
    EmployeeRepository employeeRepository;

    @Override
    public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = new Employee();

        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastName(employeeRequest.getLastName());
        newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setDepartment(employeeRequest.getDepartment());

        employeeRepository.save(newEmployee);

        return new MessageResponse("A new employee record has  been successfully created");
    }

    @Override
    public Optional<Employee> updateEmployee(Long employeeId, EmployeeRequest employeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()){
            throw new ResourceNotFoundException("Employee","Id", employeeId);
        }
        else {
            employee.get().setFirstName(employeeRequest.getFirstName());
            employee.get().setLastName(employeeRequest.getLastName());
            employee.get().setPhoneNumber(employeeRequest.getPhoneNumber());
            employee.get().setEmail(employeeRequest.getEmail());
            employee.get().setDepartment(employeeRequest.getDepartment());

            employeeRepository.save(employee.get());

        }
        return employee;
    }

    @Override
    public void deleteEmployee(Long employeeId) throws ResourceNotFoundException {
        if (employeeRepository.getById(employeeId).getId().equals(employeeId)){
            employeeRepository.deleteById(employeeId);
        }
        else throw new ResourceNotFoundException("Employee", "Id", employeeId);
    }

    @Override
    public Employee getSingleEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
