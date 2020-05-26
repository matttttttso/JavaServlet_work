package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;

public class EmpUpdateLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
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
		empParams.add(request.getParameter("imageID"));
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
