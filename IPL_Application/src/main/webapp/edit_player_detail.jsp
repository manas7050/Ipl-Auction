<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_to_player_detail_edit_page</h1>
<special:form action="updateplayer" method="post" modelAttribute="player">
<special:input path="id" hidden="true"/>
<h2>Name: <special:input path="name" hidden="true"/></h2>  
<h2>User_name: <special:input path="username" /></h2>
<h2>Password: <special:input path="password"/></h2><br>
Role :
<special:select path="role" id="xc">
<special:option value="Batsman">Batsman</special:option>
<special:option value="Bowler">Bowler</special:option>
<special:option value="Wicket_Keeper">Wicket_Keeper</special:option>
<special:option value="allrounder">All rounder</special:option>
</special:select> <br><br>
Country: <special:input path="country"  hidden="true"></special:input>
Base Price:<special:input path="baseprice"></special:input>
<special:button>Signup</special:button>
</special:form>

</body>
</html>