package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Picture;

public class ImageDAO {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/servletWork";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Picture> findAllDept() {
		List<Picture> pictureList = new ArrayList<Picture>();
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement("SELECT pict_id,image FROM IMAGE ORDER BY pict_id");
				ResultSet rs = pstmt.executeQuery();
			) {
			while (rs.next()) {
				int pict_id = Integer.parseInt(rs.getString("pict_id"));
				Image image = rs.getString("dept_name");
				Picture sw = new Picture(pict_id, image);
				deptList.add(sw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return deptList;
	}

	public boolean updateDept(String deptID, String deptName) {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement("UPDATE DEPT SET DEPT_NAME = ? WHERE DEPT_ID = ?");
			) {
			pstmt.setString(1, deptName);
			pstmt.setString(2, deptID);
			int result = pstmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addDept(String deptID, String deptName) {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DEPT (dept_id,dept_name) VALUES (?,?)");
			) {
			pstmt.setString(1, deptID);
			pstmt.setString(2, deptName);
			int result = pstmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteDept(String deptID) {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM DEPT WHERE DEPT_ID IS ?");
			) {
			pstmt.setString(1, deptID);
			int result = pstmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
