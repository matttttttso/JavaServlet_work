package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Dept;
import dao.DeptDAO;

public class DeptListLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		DeptDAO deptDAO = new DeptDAO();
		List<Dept> deptAllList = deptDAO.findAllDept();
		session.setAttribute("deptAllList", deptAllList);
		if (deptAllList == null) {
			request.setAttribute("message", "部署の登録データがありません。");
		}
		return "dept_list.jsp";
	}
}
