<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Prefecture"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員データの修正</title>
</head>
<body>
	<h2>社員データを修正します</h2>
	<form action="#" method="post">
		<p>社員ID：<input type="text" name="employeeID"></p>
		<p>名前：<input type="text" name="name"></p>
		<p>年齢：<input type="text" name="age"></p>
		<p>性別：
			<input type="radio" name="gender" value="男">男性
			<input type="radio" name="gender" value="女">女性
		</p>
		<p>写真：<input type="file" name="image"></p>
		<p>郵便番号：<input type="text" name="zipcode"></p>
		<p>都道府県：<select name="prefecture">
				<option value="">未指定</option>
				<c:forEach var="pref" items="${ Prefecture.values() }">
					<option value="${ pref.code }">${ pref.fullText }</option>
				</c:forEach>
			</select>
		</p>
		<p>住所：<input type="text" name="address"></p>
		<p>所属： <select name="department">
				<option value="">未指定</option>
				<option value="部署1">部署１</option>
				<option value="部署2">部署２</option>
				<option value="部署３">部署３</option>
				<option value="その他">その他</option>
			</select>
		</p>
		<p>入社日：<input type="text" name="dateEntering"></p>
		<p>退社日：<input type="text" name="dateRetired"></p>
		<input type="submit" value="設定">
	</form>
	<button onclick="history.back()">キャンセル</button>
</body>
</html>