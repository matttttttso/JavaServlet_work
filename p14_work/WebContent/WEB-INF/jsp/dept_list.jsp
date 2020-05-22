<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.Department"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Department> depts = new ArrayList<Department>();
	Department d1 = new Department(1, "総務部");
	Department d2 = new Department(2, "営業部");
	Department d3 = new Department(3, "開発部");
	depts.add(d1);
	depts.add(d2);
	depts.add(d3);
	session.setAttribute("list", depts);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部署データベース管理ページ</title>
</head>
<body>
	<h3>部署一覧：</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>部署名</th>
		</tr>
		<c:forEach var="dept" items="${ list }">
			<tr>
				<td><c:out value="${ dept.deptID }" /></td>
				<td><c:out value="${ dept.deptName }" /></td>
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
</body>
</html>