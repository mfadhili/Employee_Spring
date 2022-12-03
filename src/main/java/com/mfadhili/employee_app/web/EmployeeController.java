package com.mfadhili.employee_app.web;

import com.mfadhili.employee_app.data.models.Employee;
import com.mfadhili.employee_app.data.payloads.request.EmployeeRequest;
import com.mfadhili.employee_app.data.payloads.response.MessageResponse;
import com.mfadhili.employee_app.service.EmployeeService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This class contains the Employee Controller mappings and methods
 * */

@RestController /** Marks the class as an HTTP request handler and allows spring to recognise it as a restful service*/
@RequestMapping("/employee") /** Sets the base path to the resource endpoints as "/employee" */
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request. please follow API documentation for proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints thine request cannot be authorised"),
        @io.swagger.annotations.ApiResponse(code = 501, message = "Man down, please bear with us as we work to restore the server")
})
public class EmployeeController {
    @Autowired /** Autowired EmployeeService into EmployeeController class. It allows its service methods to be available. It is a dependency injection*/
    EmployeeService employeeService;

    @GetMapping("/all") /** Shortcut for @RequestMapping(method = RequestMethod.GET). It Maps HTTP GET requests to the mapped controller methods*/
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{Id}") /** @PathVariable annotation shows that a method parameter should be bound to a URI template variable*/
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("Id") Long Id) {
        Employee employee = employeeService.getSingleEmployee(Id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /** Binds the web request body to method parameter with the help og registered HttpMessageConverters.
     *  Converts the Post JSON Body into a Post Object and passes it to the mapped controller method
     * */
    @PostMapping("/add") /** Shorthand for @RequestMapping(method = RequestMethod.POST) */
    public ResponseEntity<MessageResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        MessageResponse newEmployee = employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }


    @PutMapping("update/{Id}")
    public ResponseEntity<MessageResponse> updateEmployee(@PathVariable Long Id, @RequestBody EmployeeRequest employeeUpdate){
        Optional<Employee> updateResponse = employeeService.updateEmployee(Id, employeeUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** An abbreviation for @RequestMapping(method = RequestMethod.DELETE)*/
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long Id) {
        employeeService.deleteEmployee(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
