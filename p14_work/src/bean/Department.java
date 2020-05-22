package bean;

import java.io.Serializable;

public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	private int deptID;
	private String deptName;

	public Department(){}

	public Department(int deptID, String deptName) {
		this.deptID = deptID;
		this.deptName = deptName;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
