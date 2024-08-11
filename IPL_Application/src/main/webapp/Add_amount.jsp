<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to add amount page</h1>
<% int id=Integer.parseInt(request.getParameter("id"));%>
<form action="addamount" method="post">
Amount: <input type="text" name="wallet" placeholder="Enter your ammount"> <br><br>
<input type="text" name="tid" value="<%=id%>" hidden="hidden">
<button>Add</button> <button type="reset">cancel</button>
</form>
</body>
</html>