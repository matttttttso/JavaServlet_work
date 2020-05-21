<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.Employee"%>
<%@ page import="bean.Gender"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Employee> employees = new ArrayList<Employee>();
	Employee e1 = new Employee(1, "山田", "太郎", 30, "男");
	Employee e2 = new Employee(2, "佐藤", "花子", 25, "女");
	Employee e51 = new Employee(51, "鈴木", "一朗", 46, "男");
	employees.add(e1);
	employees.add(e2);
	employees.add(e51);
	session.setAttribute("list", employees);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員データベース管理ページ</title>
</head>
<body>
	<h3>社員一覧：</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
		</tr>
		<c:forEach var="employee" items="${ list }">
			<tr>
				<td><c:out value="${ employee.employeeID }" /></td>
				<td><c:out value="${ employee.fullName }" /></td>
				<td>
					<form action="#" method="post">
						<input type="submit" value="編集">
					</form>
				</td>
				<td>
					<form action="#" method="post">
						<input type="submit" value="削除">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="#" method="post">
		<input type="submit" value="新規追加">
	</form>
	<form action="#" method="post">
		<input type="submit" value="検索...">
	</form>
		<form action="#" method="post">
		<input type="submit" value="SCVファイルに出力">
	</form>
</body>
</html>