<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録フォーム</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			User account = (User)session.getAttribute("input_data");
	%>
	<p style="color:red">登録に失敗しました。</p>
	<h1>新規登録</h1>
	<form action="RegisterUserConfirmServlet" method="post">
		　ユーザー名　　<input type="text" name="name" value="<%=account.getName()%>"><br>
		メールアドレス　<input type="email" name="email"><br>
		　　　PW　　　　<input type="password" name="pw" value="<%=account.getMail()%>"><br>
		<input type="submit" value="次へ">
		</form>
		<a href="./">戻る</a>
		<%}else{ %>
		<h1>新規登録</h1>
	<form action="RegisterUserConfirmServlet" method="post">
		　ユーザー名　　<input type="text" name="name"><br>
		メールアドレス　<input type="email" name="email"><br>
		　　　PW　　　　<input type="password" name="pw"><br>
		<input type="submit" value="次へ">
		</form>
		<a href="./">戻る</a>
		<%} %>
</body>
</html>