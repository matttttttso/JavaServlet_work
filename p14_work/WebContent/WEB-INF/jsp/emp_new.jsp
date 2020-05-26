<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Gender"%>
<%@ page import="bean.Prefecture"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員データの新規作成</title>
</head>
<body>
	<h2>社員データを新規作成します</h2>
	<form action="./EmployeeDatabase" method="post">
		<p>社員ID：<input type="text" name="empID"></p>
		<p>名前：<input type="text" name="empName"></p>
		<p>年齢：<input type="text" name="age"></p>
		<p>性別：
			<input type="radio" name="gender" value="${ Gender.MALE.text }">男性
			<input type="radio" name="gender" value="${ Gender.FEMALE.text }">女性
		</p>
		<p>写真：<input type="file" name="image"></p>
		<p>郵便番号：<input type="text" name="zipcode"></p>
		<p>都道府県：
			<select name="prefecture">
				<c:forEach var="pref" items="${ Prefecture.values() }">
					<option value="${ pref.fullText }">${ pref.fullText }</option>
				</c:forEach>
			</select>
		</p>
		<p>住所：<input type="text" name="address"></p>
		<p>所属：
			<select name="deptID">
				<c:forEach var="dept" items="${ deptAllList }">
					<option value="${ dept.deptID }">${ dept.deptName }</option>
				</c:forEach>
			</select>
		</p>
		<p>入社日：<input type="text" name="dateEntering"></p>
		<p>退社日：<input type="text" name="dateRetired"></p>
		<input type="hidden" name="action" value="action.EmpAddLogic" />
		<input type="submit" value="設定">
	</form>
	<br>
	<button onclick="history.back()">戻る</button>
</body>
</html>