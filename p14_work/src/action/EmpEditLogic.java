package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;

public class EmpEditLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Employee> empAllList = (List<Employee>) session.getAttribute("empAllList");
		int empID = Integer.parseInt(request.getParameter("empID"));

		for(Employee emp : empAllList) {
			if(emp.getEmpID() == empID) {
				request.setAttribute("empEdited", emp);
			}
		}
		return "emp_edit.jsp";
	}
}
