<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
	<%=si.getTitle() %><br>
	<%=si.getAuthor() %><br>
	<%=si.getPublisher() %><br>
	<%=si.getIsbn() %><br>
	<%=type0%><br>
	
	<a href="Registerbooks3">登録</a><br>
	<a href="../">戻る</a>	
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
       integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>