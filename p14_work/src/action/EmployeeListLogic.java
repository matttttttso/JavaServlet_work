package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;
import bean.Gender;

public class EmployeeListLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		List<Employee> employees = new ArrayList<Employee>();
		Employee e1 = new Employee(1, "山田", "太郎", 30, Gender.Male);
		Employee e2 = new Employee(2, "佐藤", "花子", 25, Gender.Female);
		Employee e51 = new Employee(51, "鈴木", "一朗", 46, Gender.Male);
		employees.add(e1);
		employees.add(e2);
		employees.add(e51);
		session.setAttribute("empList", employees);

		@SuppressWarnings("unchecked")
		List<Employee> empList = (List<Employee>) session.getAttribute("empList");

		//あとでDAOと一緒に実装
		//		EmployeeDAO dao = new EmployeeDAO();
		//		List<Employee> empList = dao.findAll();
		request.setAttribute("empList", empList);
		if (empList == null) {
			request.setAttribute("message", "社員の登録データがありません。");
		}
		return "emp_list.jsp";
	}
}
