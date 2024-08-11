<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>Welcome to view my team players page</h1>
<h1>${teamname} players are:</h1>
<body>

<%String msg =request.getParameter("msg"); 
if(msg!=null){%>
<h1>${msg}</h1>

<%}
else{%>
	
	
	<table border="1">
	<tr>
	<th>Player name</th>
	<th>Player Role</th>
	</tr>
	<special:forEach var="player" items="${players}">
	<tr>
	<th>${player.getName()}</th>
    <th>${player.getRole()}</th>
	</tr>
	</special:forEach>
	
	</table>
<%}


%>
<a href="viewteambyname.jsp"><button>Back</button></a>


</body>
</html>