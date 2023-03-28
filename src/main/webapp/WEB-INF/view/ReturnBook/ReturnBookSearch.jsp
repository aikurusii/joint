<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸し出し</title>
</head>
<body>
	<p>返したい図書のISBNを入力してください。</p>
	<form action="ReturnBookSearchResultServlet" method="post">
		図書情報<input type="text" name="isbn"><input type="submit" value="送信"><br>
	</form>
	<a href="#">戻る</a><br>
	<a href="#">トップページへ</a>
	

</body>
</html>