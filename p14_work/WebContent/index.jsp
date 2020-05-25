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
	<a href="./EmployeeDatabase?action=action.EmployeeListLogic">一覧</a>
	<form action="./EmployeeDatabase" method="post">
		<input type="hidden" name="action" value="action.EmployeeListLogic" />
		<input type="submit" value="一覧">
	</form>
	<button onclick="history.back()">キャンセル</button>
</body>
</html>