<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>登録確認</title>
</head>
<body>
	<h1>新規登録</h1>
	<p>下記の内容を登録します。</p>
	<%
		User account=(User)session.getAttribute("input_data");
	%>
	　ユーザー名　　<%=account.getName() %><br>
	メールアドレス　<%=account.getMail() %><br>
	　　　PW　　　　********<br>
	<a href="RegisterUsercom">登録</a>
	<a href="index.html">戻る</a>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
       integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>