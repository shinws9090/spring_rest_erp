package spring_rest_erp.service;

public class DuplicateEmployeeException extends RuntimeException {
	
	public DuplicateEmployeeException(String message) {
		super(message);
	}

}
