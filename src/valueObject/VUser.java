package valueObject;

public class VUser {
	
	private String userId;
	private String password;
	private String name;
	private String number;
	private String major;
	
	public VUser() {
		
	}

	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public String getMajor() {
		return major;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setMajor(String major) {
		this.major = major;
	}

}
