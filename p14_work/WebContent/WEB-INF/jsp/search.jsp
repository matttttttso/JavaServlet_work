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
	<form action="#" method="post">
		<p>
			所属部署： <select name="department">
				<option value="">未指定</option>
				<option value="部署1">部署１</option>
				<option value="部署2">部署２</option>
				<option value="部署３">部署３</option>
				<option value="その他">その他</option>
			</select>
		</p>
		<p>
			社員ID：<input type="text" name="employeeID">
		</p>
		<p>
			名前に含む文字：<input type="text" name="searchName">
		</p>
		<input type="submit" value="検索">
	</form>
</body>
</html>