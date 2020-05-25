package bean;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int employeeID; //社員番号
	private String lastName; //姓
	private String firstName; //名
	private int age; //年齢
	private Gender gender; //性別
	private Prefecture pref; //都道府県

	public Employee() {
	}

	public Employee(int employeeID, String lastName, String firstName, int age, Gender gender) {
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
	}
	public Employee(int employeeID, String lastName, String firstName, int age, Gender gender, Prefecture pref) {
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
		this.pref = pref;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Prefecture getPref() {
		return pref;
	}

	public void setPref(Prefecture pref) {
		this.pref = pref;
	}
}
