<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Dbook" %>
<%@ page import="dao.Booksdao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書削除</title>
</head>
<body>
<h1>削除したい図書のISBNで検索</h1>
	
	図書情報のisbnで検索
		<form action="DSerch"method="post">
	<div class="input-group">
  <input type="text" class="form-control" placeholder="キーワードを入力" name="keyword"> 
  <button class="btn btn-outline-success" type="submit" id="button-addon2" ><i class="fas fa-search"></i> 検索</button>
</div>
</form>
	<table border=1>
		
		<tr>
				<th>id</th>
		 	<th>タイトル</th>
            <th>著者名</th>
            <th>出版社</th>
            <th>ISBN番号</th>
            <th>評価値</th>
            </tr>
            
          <%
	List<Dbook> list = Booksdao.getDAllBookss();
	for(Dbook r : list) {
		%>
		<tr>
			<td>
				<a href="DeleteBook2?id=<%=r.getId()%>">
					<%=r.getId() %>
				</a>
			</td>
			<td><%=r.getTitle() %></td>
			<td><%=r.getAuthor() %></td>
			<td><%=r.getPublisher() %></td>
			<td><%=r.getIsbn() %></td>
			<%
			if(r.getRating() >= 0) {
				%>
				<td><%=r.getRating()%></td>
			<% } else {%>
				<td>未評価</td>
			<% } %>
		</tr>
	<% } %>
	<a href="./">戻る</a>
	</table>

</body>
</html>