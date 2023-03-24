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
	<form action="Serch"method="post">
	<div class="input-group">
  <input type="text" class="form-control" placeholder="キーワードを入力" name="keyword"> 
  <button class="btn btn-outline-success" type="submit" id="button-addon2" ><i class="fas fa-search"></i> 検索</button>
</div>
</form>
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
		<td><%=r.getStarus() %>
		</tr>
		<%} %>
</table>
</body>
</html>