package spring_rest_erp.mapper;

import java.util.List;

import spring_rest_erp.dto.Employee;

public interface EmployeeMapper {
	
	List<Employee> getLists();
    Employee getEmployee(int empNo);
    int registerEmployee(Employee employee);
    int modifyEmployee(Employee employee);
    int removeEmployee(Employee employee);
}
