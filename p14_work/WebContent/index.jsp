<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Prefecture"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップページ</title>
</head>
<body>
	<h2>一覧へ（テスト）</h2>
	<form action="./EmployeeDatabase" method="post">
		<input type="hidden" name="action" value="action.EmployeeListLogic" />
		<input type="submit" value="社員一覧">
	</form>
		<form action="./EmployeeDatabase" method="post">
		<input type="hidden" name="action" value="action.DeptListLogic" />
		<input type="submit" value="部署一覧">
	</form>
	<button onclick="history.back()">キャンセル</button>
</body>
</html>