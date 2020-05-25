package bean;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int employeeID; //社員番号
	private String name; //名前
	private int age; //年齢
	private Gender gender; //性別
	private Prefecture pref; //都道府県

	public Employee() {
	}

	public Employee(int employeeID, String name, int age, Gender gender) {
		this.employeeID = employeeID;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Employee(int employeeID, String name, int age, Gender gender, Prefecture pref) {
		this.employeeID = employeeID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.pref = pref;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
