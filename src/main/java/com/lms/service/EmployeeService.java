package com.lms.service;

import com.lms.entity.Employee;
import com.lms.payload.EmployeeDto;
import com.lms.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeDto addEmployee(EmployeeDto dto){
        Employee employee = mapToEntity(dto);
        Employee emp = employeeRepository.save(employee);
        EmployeeDto employeeDto = mapToDto(emp);
        employeeDto.setDate(new Date());
        return employeeDto;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id, EmployeeDto dto) {
       Optional<Employee> opEmp = employeeRepository.findById(id);
       Employee employee = opEmp.get();
        employee.setName(dto.getName());
        employee.setEmailId(dto.getEmailId());
        employee.setMobile(dto.getMobile());
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    EmployeeDto mapToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        //dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmailId(employee.getEmailId());
        dto.setMobile(employee.getMobile());
        return dto;
    }
    Employee mapToEntity(EmployeeDto dto) {
        Employee emp = new Employee();
        //emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setEmailId(dto.getEmailId());
        emp.setMobile(dto.getMobile());
        return emp;
    }
}



