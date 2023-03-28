<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="dto.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>検索結果</h2>
	<p>この本を借りますか？</p>
	
	<%
	//HttpSession session = request.getSession();
	List<Book> list = (ArrayList<Book>)session.getAttribute("list");
	for(Book b : list) {
	%>
		
		ID：<%=b.getId() %><br>
		タイトル：<%=b.getTitle() %><br>
		著者：<%=b.getAuthor() %><br>
		ISBN番号<%=b.getIsbn() %><br>
		出版社：<%=b.getPublisher() %><br>
		評価：<%=b.getStatus() %><br>
				

	<%} %>
	
	<a href="BorrowBookExecuteServlet">はい</a><br>
	<a href="BorrowBookSearchServlet">いいえ</a>
</body>
</html>