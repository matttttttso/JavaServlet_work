package action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Picture;
import dao.EmployeeDAO;
import dao.ImageDAO;

public class EmpAddLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String f = request.getParameter("picture");
		@SuppressWarnings("unchecked")
		List<Picture> imageAllList = (List<Picture>) session.getAttribute("imageAllList");
		int pictID = imageAllList.size() + 1;
		InputStream is = null;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ImageDAO imageDAO = new ImageDAO();
		if (imageDAO.addImage(pictID, is) == false) {
			request.setAttribute("errotMessage", "データベースへの登録に失敗しました。（画像データ）");
			return "error.jsp";
		}

		boolean empIDisNull = request.getParameter("empID").equals("");
		boolean empNameisNull = request.getParameter("empName").equals("");
		if (empIDisNull || empNameisNull) {
			request.setAttribute("errotMessage", "IDと名前は必須です。");
			return "error.jsp";
		}
		List<String> empParams = new ArrayList<String>();
		empParams.add(request.getParameter("empID"));
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
		EmployeeDAO empDao = new EmployeeDAO();
		if (empDao.addEmp(empParams) == false) {
			request.setAttribute("errotMessage", "データベースへの登録に失敗しました。");
			return "error.jsp";
		}
		request.setAttribute("message", "データベースへの登録に成功しました。");
		return "success.jsp";
	}
}
