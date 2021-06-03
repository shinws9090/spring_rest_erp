package spring_rest_erp.service;

import java.util.List;

import spring_rest_erp.dto.Employee;

public interface EmployeeService {
	List<Employee> getLists();
    Employee getEmployee(int empNo);
    int registerEmployee(Employee employee);
    int modifyEmployee(Employee employee);
    int removeEmployee(Employee employee);
}
