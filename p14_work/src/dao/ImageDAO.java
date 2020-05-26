package dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import bean.Picture;

public class ImageDAO {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/servletWork";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Picture> findAllImage() {
		List<Picture> pictureAllList = new ArrayList<Picture>();
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement("SELECT pict_id,pict_image FROM PICTURE ORDER BY pict_id");
				ResultSet rs = pstmt.executeQuery();
			) {
			while (rs.next()) {
				int pict_id = rs.getInt("pict_id");
				Blob blob = rs.getBlob("pict_image");
				byte[] b = blob.getBytes(1, (int)blob.length());
				String imageSTR = Base64.getEncoder().encodeToString(b);
				Picture sw = new Picture(pict_id, imageSTR);
				pictureAllList.add(sw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pictureAllList;
	}

	public boolean updateImage(int pictID, InputStream is) {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn.prepareStatement("UPDATE PICTURE SET pict_image = ? WHERE pict_id = ?");) {
			pstmt.setBlob(1, is);
			pstmt.setInt(2, pictID);
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

	public boolean addImage(int pictID, InputStream is) {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (
				Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pstmt = conn
						.prepareStatement("INSERT INTO PICTURE (pict_id,pict_image) VALUES (?,?)");) {
			pstmt.setInt(1, pictID);
			pstmt.setBlob(2, is);
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
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM DEPT WHERE DEPT_ID IS ?");) {
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
