package com.self.EMS.service.Impl;

import com.self.EMS.exception.ResourceNotFoundException;
import com.self.EMS.model.Employee;
import com.self.EMS.repository.EmployeeRepository;
import com.self.EMS.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeRepository employeeRepository;

    // no @AutoWired annotation is need since there is only one constructor.
    // no need to @Transactional annotation since it implements Em
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
      /* Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent())
            return employee.get();
        else
            throw  new ResourceNotFoundException("Employee", "ID", id);*/
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "ID", id));
    }

    @Override
    public Employee updateEmploye(Employee employee, long id) {
        //check if there is an employee with a given id
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "ID", id));

        existingEmployee.setName(employee.getName());
        existingEmployee.setLastname(employee.getLastname());
        existingEmployee.setEmail(employee.getEmail());
        //save
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Employee", "ID", id));
        employeeRepository.deleteById(id);
    }
}
