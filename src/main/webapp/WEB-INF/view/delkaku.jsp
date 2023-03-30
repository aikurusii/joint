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
		String type0;
		int type=si.getType();
		if(type==0){
			type0="旧";
		}else {
			type0="新";
		}
	%>
	<%=si.getId() %>
	<%=si.getTitle() %><br>
	<%=si.getAuthor() %><br>
	<%=si.getPublisher() %><br>
	<%=si.getIsbn() %><br>
	<%=type0%><br>
	

</body>
</html>