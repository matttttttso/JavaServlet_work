<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.Department"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<c:forEach var="dept" items="${ deptList }">
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