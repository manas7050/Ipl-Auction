<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<h1>Welcome To Team Signup Page</h1>
</head>
<body>
<special:form action="teamSignup" method="post" modelAttribute="team">
<h2>Name: <special:input path="name" /></h2>  
<h2>Username: <special:input path="username" /></h2>
<h2>Password: <special:input path="password"/></h2><br>
<h2>Logo: <special:input path="imagelink" /></h2>
<special:button>Signup</special:button>
</special:form>
</body>
</html>