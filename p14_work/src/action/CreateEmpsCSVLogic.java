package action;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;

public class CreateEmpsCSVLogic implements CommonLogic {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Employee> empAllList = (List<Employee>) session.getAttribute("empAllList");
		if (empAllList == null) {
			request.setAttribute("message", "社員の登録データがありません。");
		}
		String FILE_NAME = "employeeList.csv";
		String FILE = System.getProperty("user.home") + "/Desktop/" + FILE_NAME;
		try (
				BufferedWriter outputResult = Files.newBufferedWriter(Paths.get(FILE));
			) {
			outputResult.write("emp_id,emp_name,age,gender,image_id,zipcode,prefecture,address,dept_id,date_entering,date_retired");
			outputResult.write(String.format("%n"));
			for(Employee emp : empAllList) {
				outputResult.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
						emp.getEmpID(), emp.getEmpName(), emp.getAge(), emp.getGender().toString(),
						emp.getPictID(), emp.getZipcode(), emp.getPref().getFullText(), emp.getAddress(), emp.getDeptID(), emp.getDateEntering(),
						emp.getDateRetired()));
			}
		} catch (IOException e) {
			e.printStackTrace();
			request.setAttribute("errotMessage", "CSVファイルの作成に失敗しました。");
			return "error.jsp";
		}
		request.setAttribute("message", "社員リストのCSVファイルをデスクトップに作成しました。");
		return "success.jsp";
	}
}
