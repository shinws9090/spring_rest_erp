package spring_rest_erp.mapper;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring_rest_erp.config.ContextRoot;
import spring_rest_erp.dto.Department;
import spring_rest_erp.dto.Employee;
import spring_rest_erp.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@WebAppConfiguration
public class EmployeeMapperTest {

	private static final Log log = LogFactory.getLog(EmployeeMapperTest.class);

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Autowired
	private EmployeeMapper mapper;
	
	@Test
	public void test01SelectEmployeeByAll() {
		System.out.println("test01SelectEmployeeByAll");
		List<Employee> list = mapper.getLists();

		Assert.assertNotNull(list);

		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectEmployeeByNo() {
		System.out.println("test02SelectEmployeeByNo");
		Employee employee = mapper.getEmployee(4377);

		Assert.assertNotNull(employee);
		System.out.println(employee);
	}

	@Test
	public void test03InsertEmployee() {
		System.out.println("test03InsertEmployee");

		Employee employee = new Employee(9999, "이름", new Title(1),new Employee(4377), 5000000, new Department(3));
		int res = mapper.registerEmployee(employee);

		Assert.assertEquals(res, 1);
		System.out.println(mapper.getEmployee(9999));
	}

	@Test
	public void test04UpdateEmployee() {
		System.out.println("test04UpdateEmployee");

		int res = mapper.modifyEmployee(
				new Employee(9999, "이름이다", new Title(2),new Employee(4377), 34343343, new Department(4)));

		Assert.assertEquals(res, 1);
		System.out.println(mapper.getEmployee(9999));
	}

	@Test
	public void test05DeleteEmployee() {
		System.out.println("test05DeleteEmployee");

		int res = mapper.removeEmployee(new Employee(9999));

		Assert.assertEquals(res, 1);
	}

}
