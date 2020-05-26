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
		String f = request.getParameter("picture");
		int pictID = Integer.parseInt(request.getParameter("pictID"));
		InputStream is = null;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ImageDAO imageDAO = new ImageDAO();
		if (imageDAO.updateImage(pictID, is) == false) {
			request.setAttribute("errotMessage", "データベースへの登録に失敗しました。（画像データ）");
			return "error.jsp";
		}

		boolean empIDisNull = request.getParameter("empID").equals("");
		boolean empNameisNull = request.getParameter("empName").equals("");
		if(empIDisNull || empNameisNull) {
			request.setAttribute("errotMessage", "IDと名前は必須です。");
			return "error.jsp";
		}

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
		empParams.add(request.getParameter("empID"));
		EmployeeDAO empDao = new EmployeeDAO();
		if (empDao.updateEmp(empParams) == false) {
			request.setAttribute("errotMessage", "データベースへの登録に失敗しました。");
			return "error.jsp";
		}
		request.setAttribute("message", "データベースへの登録に成功しました。");
		return "success.jsp";
	}
}
