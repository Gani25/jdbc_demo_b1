package standard.com.sprk.entity;

import java.sql.Timestamp;

public class Employee {
	
	private int empId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String gender;
	
	private Timestamp createdAt;

	private Timestamp updatedAt;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	

}
