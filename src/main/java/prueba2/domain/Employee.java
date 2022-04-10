package prueba2.domain;

public class Employee {

	private Long id;
	private String fullname;
	private String functions;
	
	private Long bossId;
	private Employee boss;
	
	public Employee() {
		
	}
	
	public Employee(Long id) {
		this.id = id;
	}

	public Employee(String fullname, String functions, Long bossId) {
		this.fullname = fullname;
		this.functions = functions;
		this.bossId = bossId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFunctions() {
		return functions;
	}

	public void setFunctions(String functions) {
		this.functions = functions;
	}

	public Employee getBoss() {
		return boss;
	}

	public void setBoss(Employee boss) {
		this.boss = boss;
	}
	
	
	public Long getBossId() {
		return bossId;
	}

	public void setBossId(Long bossId) {
		this.bossId = bossId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", functions=" + functions + ", boss=" + boss + "]";
	}
	
}
