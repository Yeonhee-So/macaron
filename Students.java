import java.io.Serializable;


public class Students implements Serializable{
	private String name;
	private String id;
	private String department;
	private String phone_number;
	
	public Students(String name, String id, String department, String phone_number) {
		this.name = name;
		this.id = id;
		this.department = department;
		this.phone_number = phone_number;
	}
	
	public String toString() {
		String description;

		description = name;
		description += "\t" + id;
		description += "\t\t" + department;
		description += "\t"+ phone_number;
		
		return description;
	}
	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getDepartment() {
		return department;
	}
	public String getPhoneNumber() {
		return phone_number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}	
}
