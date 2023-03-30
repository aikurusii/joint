<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>ログイン画面</h1>
	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>
		<p style="color:bule">ログイン失敗</p>
	<form action="Log" method="post">
		メールアドレス<input type="text" name="mail" value="<%=request.getParameter("mail") %>"><br>
		　　　PW　　　<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<a href="./">戻る</a><br>
	<%
		} else {
	%>
	<form action="Log" method="post">
		メールアドレス<input type="text" name="mail"><br>
		　　　PW　　　<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<a href="./">戻る</a>
	<%
		}
	%>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
       integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>