package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;

public class EmpSearchLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Employee> empAllList = (List<Employee>) session.getAttribute("empAllList");
		final String notext = "指定無し";
		int searchDeptID = Integer.parseInt(request.getParameter("searchDept"));
		String searchEmpID = request.getParameter("searchEmpID");
		if (searchEmpID.equals("")) {
			searchEmpID = notext;
		}
		String searchName = request.getParameter("searchName");
		if (searchName.equals("")) {
			searchName = notext;
		}
		List<Employee> searchedEmpList = new ArrayList<Employee>();

		for (Employee emp : empAllList) {
			boolean matchedSearchDept = true;
			if(searchDeptID != 0){
				matchedSearchDept = emp.getDeptID() == searchDeptID;
			}
			if (matchedSearchDept) {
				boolean matchedEmpID = true;
				if (!searchEmpID.equals(notext)) {
					matchedEmpID = String.valueOf(emp.getEmpID()).equals(searchEmpID);
				}
				boolean containsSearchName = true;
				if (!searchName.equals(notext)) {
					containsSearchName = emp.getEmpName().contains(searchName);
				}
				if (matchedEmpID && containsSearchName) {
					searchedEmpList.add(emp);
				}
			}
		}
		request.setAttribute("searchedEmpList", searchedEmpList);
		return "emp_searchResult.jsp";
	}
}
