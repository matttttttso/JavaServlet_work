package bean;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int employeeID; //社員番号
	private String lastName; //姓
	private String firstName; //名
	private int age; //年齢
	private String gender; //性別

	public Employee() {
	}

	public Employee(int employeeID, String lastName, String firstName, int age, String gender) {
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
	}

	public String getFullName() {
		return this.lastName + " " + this.firstName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
