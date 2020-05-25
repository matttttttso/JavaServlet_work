package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Dept;
import bean.Employee;
import bean.Gender;
import bean.Prefecture;

public class EmployeeListLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		List<Dept> depts = new ArrayList<Dept>();
		Dept d1 = new Dept(1, "営業部");
		Dept d2 = new Dept(2, "総務部");
		Dept d3 = new Dept(3, "運動部");
		Dept d4 = new Dept(4, "その他");
		depts.add(d1);
		depts.add(d2);
		depts.add(d3);
		depts.add(d4);
		session.setAttribute("deptList", depts);

		List<Employee> employees = new ArrayList<Employee>();
		Employee e1 = new Employee(1, "山田 太郎", 30, Gender.Male, Prefecture.FUKUOKA, d1);
		Employee e2 = new Employee(2, "佐藤 花子", 25, Gender.Female, Prefecture.TOKYO, d2);
		Employee e51 = new Employee(51, "鈴木 一朗", 46, Gender.Male, Prefecture.AICHI, d3);
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
