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
	<c:if test="${ !empty message }">
		<p>${ message }</p>
		<p>${ empID }</p>
	</c:if>
	<h2>社員データを修正します</h2>
	<form action="#" method="post">
		<p>社員ID：<input type="text" name="employeeID" value="${ empEdited.employeeID }"></p>
		<p>名前：<input type="text" name="name" value="${ empEdited.name }"></p>
		<p>年齢：<input type="text" name="age" value="${ empEdited.age }"></p>
		<p>性別：
			<input type="radio" name="gender" value="${ Gender.Male }" <c:if test="${ empEdited.gender == 'Male' }">checked</c:if>>男性
			<input type="radio" name="gender" value="${ Gender.Female }" <c:if test="${ empEdited.gender == 'Female' }">checked</c:if>>女性
		</p>
		<p>写真：<input type="file" name="image"></p>
		<p>郵便番号：<input type="text" name="zipcode"></p>
		<p>都道府県：
			<select name="prefecture">
				<c:forEach var="pref" items="${ Prefecture.values() }">
					<option value="${ pref.code }" <c:if test="${ empEdited.pref == pref }">selected</c:if>>${ pref.fullText }</option>
				</c:forEach>
			</select>
		</p>
		<p>住所：<input type="text" name="address"></p>
		<p>所属： <select name="dept">
				<option value="unselected">未指定</option>
				<option value="営業部">営業部</option>
				<option value="経理部">経理部</option>
				<option value="運動部">運動部</option>
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