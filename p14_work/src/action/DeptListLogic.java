package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Department;

public class DeptListLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		List<Department> depts = new ArrayList<Department>();
		Department d1 = new Department(1, "営業部");
		Department d2 = new Department(2, "総務部");
		Department d3 = new Department(3, "運動部");
		Department d4 = new Department(4, "その他");
		depts.add(d1);
		depts.add(d2);
		depts.add(d3);
		depts.add(d4);
		session.setAttribute("deptList", depts);

		@SuppressWarnings("unchecked")
		List<Department> deptList = (List<Department>) session.getAttribute("deptList");

		request.setAttribute("deptList", deptList);
		if (deptList == null) {
			request.setAttribute("message", "部署の登録データがありません。");
		}
		return "dept_list.jsp";
	}
}
