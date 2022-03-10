package com.self.EMS.controller;

import com.self.EMS.model.Employee;
import com.self.EMS.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Controller + ResponseBody
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //RequestBody annotation allows us to retrieve the
    //request's body and  automatically convert it to Java Object
    @PostMapping()
    public ResponseEntity<Employee> save(@RequestBody  Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED) ;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmploye(employee,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }
}
