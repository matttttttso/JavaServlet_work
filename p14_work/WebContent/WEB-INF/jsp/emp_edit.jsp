<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Gender"%>
<%@ page import="bean.Prefecture"%>
<%@ page import="bean.Picture"%>
<%@ page import="bean.Employee"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員データの修正</title>
</head>
<body>
	<h2>社員データを修正します</h2>
	<form action="./EmployeeDatabase" method="post">
		<p>社員ID：<input type="text" name="empID" value="${ empEdited.empID }"></p>
		<p>名前：<input type="text" name="empName" value="${ empEdited.empName }"></p>
		<p>年齢：<input type="text" name="age" value="${ empEdited.age }"></p>
		<p>性別：
			<input type="radio" name="gender" value="${ Gender.MALE.text }" <c:if test="${ empEdited.gender == 'MALE' }">checked</c:if>>男性
			<input type="radio" name="gender" value="${ Gender.FEMALE.text }" <c:if test="${ empEdited.gender == 'FEMALE' }">checked</c:if>>女性
		</p>
		<p>写真：<input type="file" name="picture"></p>
		<input type="hidden" name="pictID" value="${ empEdited.pictID }">
		<input type="hidden" name="pictureSTR" value="${ pictureSTR }">
		<img style="width: 200px; height: 200px" src="data:image/png;base64,${ pictureSTR }">
		<p>郵便番号：<input type="text" name="zipcode" value="${ empEdited.zipcode }"></p>
		<p>都道府県：
			<select name="prefecture">
				<c:forEach var="pref" items="${ Prefecture.values() }">
					<option value="${ pref.fullText }"
						<c:if test="${ empEdited.pref.fullText == pref.fullText }">
							selected
						</c:if>>
						${ pref.fullText }
					</option>
				</c:forEach>
			</select>
		</p>
		<p>住所：<input type="text" name="address" value="${ empEdited.address }"></p>
		<p>所属：
			<select name="deptID">
				<c:forEach var="dept" items="${ deptAllList }">
					<option value="${ dept.deptID }" <c:if test="${ empEdited.deptID == dept.deptID }">selected</c:if>>${ dept.deptName }</option>
				</c:forEach>
			</select>
		</p>
		<p>入社日：<input type="text" name="dateEntering" value="${ empEdited.dateEntering }"></p>
		<p>退社日：<input type="text" name="dateRetired" value="${ empEdited.dateRetired }"></p>
		<input type="hidden" name="action" value="action.EmpUpdateLogic" />
		<input type="submit" value="設定">
	</form>
	<br>
	<button onclick="history.back()">戻る</button>
</body>
</html>