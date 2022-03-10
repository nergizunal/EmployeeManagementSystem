package com.self.EMS.service;

import com.self.EMS.model.Employee;

import java.util.List;

public interface EmployeeService  {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmploye(Employee employee, long id);
    void deleteEmployee(long id);
}
