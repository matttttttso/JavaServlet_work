package action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.ImageDAO;

public class EmpUpdateLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		boolean empIDisNull = request.getParameter("empID").equals("");
		boolean empNameisNull = request.getParameter("empName").equals("");
		if(empIDisNull || empNameisNull) {
			request.setAttribute("errorMessage", "IDと名前は必須です。");
			return "error.jsp";
		}
		String empIDstr = request.getParameter("empID");
		int pictID = Integer.parseInt(empIDstr);
		List<String> empParams = new ArrayList<String>();
		empParams.add(request.getParameter("empName"));
		empParams.add(request.getParameter("age"));
		empParams.add(request.getParameter("gender"));
		empParams.add(String.valueOf(pictID));
		empParams.add(request.getParameter("zipcode"));
		empParams.add(request.getParameter("prefecture"));
		empParams.add(request.getParameter("address"));
		empParams.add(request.getParameter("deptID"));
		empParams.add(request.getParameter("dateEntering"));
		empParams.add(request.getParameter("dateRetired"));
		empParams.add(empIDstr);
		EmployeeDAO empDao = new EmployeeDAO();
		if (empDao.updateEmp(empParams) == false) {
			request.setAttribute("errorMessage", "データベースへの登録に失敗しました。(EMP)");
			return "error.jsp";
		}

		String f = request.getParameter("picture");
		InputStream is = null;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ImageDAO imageDAO = new ImageDAO();
		String pictureSTR = request.getParameter("pictureSTR");
		if(pictureSTR == null) {
			if (imageDAO.addImage(pictID, is) == false) {
				request.setAttribute("errorMessage", "データベースへの登録に失敗しました。（画像データadd）");
				return "error.jsp";
			}
		} else {
			if (imageDAO.updateImage(pictID, is) == false) {
				request.setAttribute("errorMessage", "データベースへの登録に失敗しました。（画像データupdate）");
				return "error.jsp";
			}
		}

		request.setAttribute("message", "データベースへの登録に成功しました。");
		return "success.jsp";
	}
}
