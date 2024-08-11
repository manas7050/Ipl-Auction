<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to view team by name page</h1>
	<h1>Select_team</h1>
	<form action="fetchUsingTeamName" method="post">
		<select name="name">
			<special:forEach var="team" items="${teams}">
				<option value="${team.getName()}">${team.getName()}</option>
			</special:forEach>
		</select>
		<button type="submit">Search</button>
	</form> <br><br>
	<a href="ManagementHome.jsp"><button>Back</button></a>
</body>
</html>