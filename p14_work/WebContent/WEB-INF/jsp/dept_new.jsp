<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Prefecture"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部署データの新規作成</title>
</head>
<body>
	<h2>部署データを新規作成します</h2>
	<form action="./EmployeeDatabase" method="post">
		<input type="hidden" name="deptID" value="${ fn:length(deptAllList) + 1 }">
		<p>部署名：<input type="text" name="deptName"></p>
		<input type="hidden" name="action" value="action.DeptAddLogic" />
		<input type="submit" value="設定">
	</form>
	<button onclick="history.back()">キャンセル</button>
</body>
</html>