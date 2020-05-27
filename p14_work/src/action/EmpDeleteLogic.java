package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.ImageDAO;

public class EmpDeleteLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String empID = request.getParameter("empID");
		EmployeeDAO empDao = new EmployeeDAO();
		if (empDao.deleteEmp(empID) == false) {
			request.setAttribute("errorMessage", "レコードの削除に失敗しました。(emp)");
			return "error.jsp";
		}
		ImageDAO imageDao = new ImageDAO();
		int pictID = Integer.parseInt(empID);
		if (imageDao.deleteImage(pictID) == false) {
			request.setAttribute("errorMessage", "レコードの削除に失敗しました。(image)");
			return "error.jsp";
		}
		request.setAttribute("message", "レコードの削除に成功しました。");
		return "success.jsp";
	}
}
