<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規図書</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String errorCode = request.getParameter("error");
	if(errorCode != null && errorCode.equals("1")){
		Book si = (Book)session.getAttribute("input_data");
	%>
	<p style="color:bule">必要な情報が入力されていません。<br>
	<h1>新規図書の登録</h1>
	<form action="Registerbooks2"method="post">
	図書名：<input type="text" name="title" value="<%=si.getTitle() %>">
	著者名：<input type="text" name="author" value="<%=si.getAuthor() %>">
	出版社：<input type="text" name="publisher" value="<%=si.getPublisher()%>">
	　ISBN:<input type="text" name="publisher" value="<%=si.getIsbn()%>">
	状態:<input type="radio" name="tyoe" value="1"> 新<br>
	<input type="radio" name="typw" value="0"> 旧
	<input type="submit" value="登録">
	<a href="./"	>戻る</a> 
	<% 
	}else{
	%>
	<h1>新規図書の登録</h1>
	<form action="Registerbooks2"method="post">
	図書名：<input type="text" name="title" >
	著者名：<input type="text" name="author" >
	出版社：<input type="text" name="publisher">
	　ISBN:<input type="text" name="publisher" >
	状態:<input type="radio" name="tyoe" value="1"> 新<br>
	<input type="radio" name="typw" value="0"> 旧
	<input type="submit" value="登録">
	<a href="./"	>戻る</a> 
	</form>
	<%} %>
</body>
</html>