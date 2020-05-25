package bean;

import java.awt.Image;
import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	private int employeeID; //社員番号
	private String name; //名前
	private int age; //年齢
	private Gender gender; //性別
	private Image image;
	private String zipcode;
	private Prefecture pref; //都道府県
	private String address;
	private String department;
	private String dateEntering;
	private String dateRetired;

	public Employee() {
	}

	public Employee(int id, String name, int age, Gender gender, Prefecture pref, String dept) {
		this.employeeID = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.pref = pref;
		this.department = dept;
	}

	public int getEmployeeID() {return employeeID;}
	public void setEmployeeID(int employeeID) {this.employeeID = employeeID;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

	public Gender getGender() {return gender;}
	public void setGender(Gender gender) {this.gender = gender;}

	public Image getImage() {return image;}
	public void setImage(Image image) {this.image = image;}

	public String getZipcode() {return zipcode;}
	public void setZipcode(String zipcode) {this.zipcode = zipcode;}

	public Prefecture getPref() {return pref;}
	public void setPref(Prefecture pref) {this.pref = pref;}

	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department = department;}

	public String getDateEntering() {return dateEntering;}
	public void setDateEntering(String dateEntering) {this.dateEntering = dateEntering;}

	public String getDateRetired() {return dateRetired;}
	public void setDateRetired(String dateRetired) {this.dateRetired = dateRetired;}
}
