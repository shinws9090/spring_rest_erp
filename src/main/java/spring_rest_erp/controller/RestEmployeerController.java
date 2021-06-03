package spring_rest_erp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_rest_erp.dto.Employee;
import spring_rest_erp.service.DuplicateEmployeeException;
import spring_rest_erp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class RestEmployeerController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/erp")
	public ResponseEntity<Object> members(){
		System.out.println("members()");
		System.out.println(service.getLists());
		return ResponseEntity.ok(service.getLists());
	}
	
	@GetMapping("/erp/{empNo}")
	public ResponseEntity<Object> member(@PathVariable("empNo")int empNo){
		Employee employee = service.getEmployee(empNo);
		if(employee==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(employee);
	}
	
	@PostMapping("/erp")
	public ResponseEntity<Object> newMember(@RequestBody Employee employee){
		System.out.println("newMember >>"+employee);
		try {
			service.registerEmployee(employee);
			
			URI uri = URI.create("/api/members/"+employee.getEmpno());
			return ResponseEntity.created(uri).body(employee.getEmpno());
		}catch(DuplicateEmployeeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	@PatchMapping("/erp")
	public ResponseEntity<Object> updateMember(@RequestBody Employee employee){
		System.out.println("updateMember >>" + employee);
		return ResponseEntity.ok(service.modifyEmployee(employee));
	}
	@DeleteMapping("/erp")
	public ResponseEntity<Object> deleteMember(@RequestBody Employee employee){
		System.out.println("deleteMember >>" + employee);
		return ResponseEntity.ok(service.removeEmployee(employee));
	}

	
}
