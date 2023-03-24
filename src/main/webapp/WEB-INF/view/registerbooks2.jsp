<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
</head>
<body>
	<h1>以下の図書で間違いないでしょうか？</h1>
		<%
 		 	Book si=(Book)session.getAttribute("input_data");
	%>
	<%=si.getTitle() %><br>
	<%=si.getAuthor() %><br>
	<%=si.getPublisher() %><br>
	<%=si.getType() %>
	<%=si.getIsbn() %><br>
	
	<s href="Registerbooks3">登録</s><br>
	<a href="../">戻る</a>	
</body>
</html>