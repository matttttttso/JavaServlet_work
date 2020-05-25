<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員データベース検索ページ</title>
</head>
<body>
	<h2>条件を指定して社員情報を検索します。</h2>
	<form action="./EmployeeDatabase" method="post">
		<input type="hidden" name="action" value="action.EmployeeSearchLogic">
		<p>
			所属部署： <select name="searchDept">
				<option value="unselected">未指定</option>
				<option value="営業部">営業部</option>
				<option value="総務部">総務部</option>
				<option value="運動部">運動部</option>
				<option value="その他">その他</option>
			</select>
		</p>
		<p>
			社員ID：<input type="text" name="searchEmpID">
		</p>
		<p>
			名前に含む文字：<input type="text" name="searchName">
		</p>
		<input type="submit" value="検索">
	</form>
</body>
</html>