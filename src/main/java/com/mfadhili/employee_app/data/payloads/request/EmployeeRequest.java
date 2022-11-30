package com.mfadhili.employee_app.data.payloads.request;

/**
 * The @NotBlank and @NotNull annotations check and validate the respective fields are mapped to ensure that they are not blank or null
 * The @Email annotation checks if the annotated field is a alid email address
 *
 *  */

import com.mfadhili.employee_app.data.models.Department;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeRequest {
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String phoneNumber;
    @Email
    private String email;
    @NotNull
    @NotBlank
    private double salary;
    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Department department;

    /** Getters and setters */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
