package spring_rest_erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_rest_erp.dto.Employee;
import spring_rest_erp.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeMapper mapper;
	
	@Override
	public List<Employee> getLists() {
		
		return mapper.getLists();
	}

	@Override
	public Employee getEmployee(int empNo) {
		
		return mapper.getEmployee(empNo);
	}

	@Override
	public int registerEmployee(Employee employee) {
		Employee saerch = mapper.getEmployee(employee.getEmpno());
		if(saerch != null) {
			throw new DuplicateEmployeeException("dup employee" + employee.getEmpno());
		}
		return mapper.registerEmployee(employee);
		
	}

	@Override
	public int modifyEmployee(Employee employee) {
		
		return mapper.modifyEmployee(employee);
	}

	@Override
	public int removeEmployee(Employee employee) {
		
		return mapper.removeEmployee(employee);
	}
}
