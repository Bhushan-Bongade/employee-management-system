package com.myproject.ems.service;

import com.myproject.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> showEmployee();

    void saveEmployee(Employee employee);

    Employee fetchEmployee(Long employeeId);

    void deleteEmployee(Long employeeId);
}
