package com.lms.controller;

import com.lms.entity.Employee;
import com.lms.payload.EmployeeDto;
import com.lms.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/employee")
public class EmployeeController {

  private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }


    //http://localhost:8080/api/v1/employee/add
    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(
             @RequestBody EmployeeDto dto

    ) {
        EmployeeDto employeeDto = employeeService.addEmployee(dto);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);

    }

     @DeleteMapping
    public ResponseEntity<String> deleteEmployee(
              @RequestParam Long id
      ){
         employeeService.deleteEmployee(id);
         return new ResponseEntity<>("deleted",HttpStatus.OK);

      }
    @PutMapping
    public ResponseEntity<String> updateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto
    ){
        employeeService.updateEmployee(id,dto);
        return new ResponseEntity<>("updated", HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(

    ) {
        List<Employee> employees = employeeService.getEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);


    }
    }











