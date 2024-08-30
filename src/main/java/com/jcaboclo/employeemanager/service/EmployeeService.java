package com.jcaboclo.employeemanager.service;

import com.jcaboclo.employeemanager.exception.UserNotFoundException;
import com.jcaboclo.employeemanager.model.Employee;
import com.jcaboclo.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

   private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        System.out.println("SERVICE - Incluindo o Employee: " + employee );
        employee.setEmployeeCode(UUID.randomUUID().toString());
       return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        String myId = String.valueOf(employee.getId());
        Employee updatedEmployee =
                employeeRepository.findEmployeeById(employee.getId())
                        .orElseThrow( () -> new UserNotFoundException("User by id " + myId + " was not found"));
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        System.out.println("No SERVICE - Excluindo o Employee ID: " + id );
        employeeRepository.deleteById(id);
    }

    public Employee findEmployeeById(Long id) {
       return  employeeRepository.findEmployeeById(id)
       .orElseThrow( () -> new UserNotFoundException("User by id " + id + " was not found"))   ;
    }
}
