package spring_rest_erp.dto;

public class Title {
	private int tno;
	private String tname;
	
	
	
	public Title() {
		// TODO Auto-generated constructor stub
	}
	public Title(int tno) {
		super();
		this.tno = tno;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return String.format("Title [tno=%s, tname=%s]", tno, tname);
	}
	
	
	
	
	

}
