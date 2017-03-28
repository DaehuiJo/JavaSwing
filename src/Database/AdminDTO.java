package Database;

public class AdminDTO {

	//AdministerRegistration DTO(data save)
	private String employeeNumber;
	private String id;
	private String password;
	private String name;
	private String department;
	private String cellphone;
	private String emailAddress;
	
	
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmailaddress() {
		return emailAddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailAddress = emailaddress;
	}
	
	
	@Override
	public String toString() {
		return "AdminDTO [employeeNumber=" + employeeNumber + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", department=" + department + ", cellphone=" + cellphone + ", emailaddress=" + emailAddress + "]";
	}
	
}
