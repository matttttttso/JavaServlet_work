package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;

public class DeptAddLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String deptID = request.getParameter("deptID");
		if (!deptID.matches("[1-9]|[1-9][0-9]")) {
			request.setAttribute("errorMessage", "部署IDは1～99で入力してください");
			return "error.jsp";
		}
		String deptName = request.getParameter("deptName");
		DeptDAO deptDao = new DeptDAO();
		if (deptDao.addDept(deptID, deptName) == false) {
			request.setAttribute("errorMessage", "データベースへの登録に失敗しました。");
			return "error.jsp";
		}
		request.setAttribute("message", "データベースへの登録に成功しました。");
		return "success.jsp";
	}
}
