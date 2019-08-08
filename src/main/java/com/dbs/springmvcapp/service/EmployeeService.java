package com.dbs.springmvcapp.service;

import com.dbs.springmvcapp.model.Employee;
import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> listAll();

    Employee findById(long empId);

    void deleteEmployee(long empId);
}