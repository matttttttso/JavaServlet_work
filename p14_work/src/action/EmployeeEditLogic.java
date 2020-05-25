package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;

public class EmployeeEditLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Employee> empList = (List<Employee>) session.getAttribute("empList");
		int empID = Integer.parseInt(request.getParameter("empID"));

		for(Employee emp : empList) {
			if(emp.getEmployeeID() == empID) {
				request.setAttribute("empEdited", emp);
				request.setAttribute("message", "見つかりました");
				request.setAttribute("empID", emp.getEmployeeID());
			}
		}
		return "emp_edit.jsp";
	}
}
