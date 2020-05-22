<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Prefecture"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部署データの作成・修正</title>
</head>
<body>
	<h2>部署データを作成・修正します</h2>
	<form action="#" method="post">
		<p>名前：<input type="text" name="name"></p>
		<input type="submit" value="設定">
	</form>
	<button onclick="history.back()">キャンセル</button>
</body>
</html>