<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="dto.Rbook" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>図書一覧</h1>
<table class=1>
	<tr>
	<th>図書名</th>
	<th>著者名</th>
	<th>出版社</th>
	<th>ISBN</th>
	<th>評価値</th>
	<th>貸出可</th>
	</tr>
	<%
	List<Rbook> list =(ArrayList<Rbook>)request.getAttribute("list");
	for(Rbook r :list){
	%>
	<tr>
		<td><%=r.getTitle() %></td>
		<td><%=r.getAuthor() %></td>
		<td><%=r.getPublisher() %></td>
		<td><%=r.getIsbn() %></td>
		<td><%=r.getRating() %></td>
		<td><%=r.getSt() %></td>
		</tr>
		<%} %>
</table>
</body>
</html>