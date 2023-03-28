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
	<p>返したい図書のIDをクリックしてください。</p>
	
		<table border="1">
		<tr>
			<th>ID</th>
			<th>タイトル</th>
			<th>著者</th>
			<th>ISBN番号</th>
			<th>出版社</th>
			<th>評価</th>
			<th>貸し出し状況</th>
		</tr>
	<%
	//HttpSession session = request.getSession();
	List<Book> list = (ArrayList<Book>)session.getAttribute("list");
	for(Book b : list) {
	%>
		<tr>
			<td><a href="ReturnBookConfirmServlet"><%=b.getId() %></a></td>
			<td><%=b.getTitle() %></td>
			<td><%=b.getAuthor() %></td>
			<td><%=b.getIsbn() %></td>
			<td><%=b.getPublisher() %></td>
			<td><%=b.getStatus() %></td>
			<%
				String type = b.getType();
				if (type.equals("1")) {
			%>
					<td>借りられます</td>
			<%
				} else if (type.equals("0")) {
			%>
					<td>貸し出し中</td>
			<%
				}
			%>
		</tr>
	<%} %>
	</table>
</body>
</html>