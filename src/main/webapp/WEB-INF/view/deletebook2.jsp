<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <p>ID：<%= request.getAttribute("id") %></p>
    <p>この図書を本当に削除してもよろしいですか？</p>
    <form action="DeleteBookCompleted" method="post">
        <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
        <button type="submit">削除する</button>
    </form>
    <a href="javascript:history.back()">キャンセル</a>
</body>
</html>