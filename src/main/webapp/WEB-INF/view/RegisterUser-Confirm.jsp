<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
</head>
<body>
	<h1>新規登録</h1>
	<p>下記の内容を登録します。</p>
	<% User account=(User)session.getAttribute("input_data"); %>
	　ユーザー名　　<%=account.getName() %>
	メールアドレス　<%=account.getMail() %>
	　　　PW　　　　********<br>
	<a href="RegisterUsercom">登録</a>
	<a href="index.html">戻る</a>
</body>
</html>