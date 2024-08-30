package com.jcaboclo.employeemanager.facade;

import com.jcaboclo.employeemanager.exception.UserNotFoundException;
import com.jcaboclo.employeemanager.model.Employee;
import com.jcaboclo.employeemanager.service.EmployeeService;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeFacade {

    final private EmployeeService employeeService;

    public EmployeeFacade(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getAllEmployee() {
      return employeeService.findAllEmployees();
    }

    public Employee findEmployeeById(Long id) {
        return employeeService.findEmployeeById(id);
    }

    public Employee addEmployee(Employee employee) {
        System.out.println("FACADE - Incluindo o Employee: " + employee );
        return employeeService.addEmployee(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    public void deleteEmployee(Long id) {
        System.out.println("No FACADE - Excluindo o Employee ID: " + id );
        employeeService.deleteEmployee(id);
    }
}
