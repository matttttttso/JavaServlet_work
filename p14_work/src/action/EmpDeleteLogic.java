package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;

public class EmpDeleteLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String empID = request.getParameter("empID");
		EmployeeDAO empDao = new EmployeeDAO();
		if (empDao.deleteEmp(empID) == false) {
			request.setAttribute("errorMessage", "レコードの削除に失敗しました。");
			return "error.jsp";
		}
		request.setAttribute("message", "レコードの削除に成功しました。");
		return "success.jsp";
	}
}
