<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<th>部署</th>
		</tr>
		<c:forEach var="employee" items="${ searchedEmpList }">
			<tr>
				<td><c:out value="${ employee.employeeID }" /></td>
				<td><c:out value="${ employee.name }" /></td>
				<td><c:out value="${ employee.dept }" /></td>
				<td>
					<form action="./EmployeeDatabase" method="post">
						<input type="hidden" name="action" value="action.EmployeeEditLogic" />
						<input type="hidden" name="empID" value="${ employee.employeeID }">
						<input type="submit" value="編集">
					</form>
				</td>
				<td>
					<form action="#" method="post">
						<input type="hidden" name="empID" value="${ employee.employeeID }">
						<input type="submit" value="削除">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="#" method="post">
		<input type="submit" value="新規追加">
	</form>
	<form action="./EmployeeDatabase" method="post">
		<input type="hidden" name="action" value="search" />
		<input type="submit" value="検索...">
	</form>
</body>
</html>