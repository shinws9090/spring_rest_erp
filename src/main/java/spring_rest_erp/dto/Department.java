package spring_rest_erp.dto;

public class Department {
	private int deptno;
	private String deptname;
	private int floor;
	
	

	public Department() {
	}

	public Department(int deptno) {
		this.deptno = deptno;
	}

	public Department(int deptno, String deptname) {
		this.deptno = deptno;
		this.deptname = deptname;
	}

	

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	

	@Override
	public String toString() {
		return String.format("Department [deptno=%s, deptname=%s, floor=%s]", deptno, deptname, floor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptno != other.deptno)
			return false;
		return true;
	}

}
