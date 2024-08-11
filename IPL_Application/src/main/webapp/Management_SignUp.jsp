<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style  >
#manas{
width: 350px;
height: 250px;
border: 1px solid black;
margin: 100px auto;
text-align: center;
background: white;
box-shadow: rgba(50, 50, 93, 0.25) 0px 13px 27px -5px, rgba(0, 0, 0, 0.3) 0px 8px 16px -8px;
}
 
body{
background-image: url("https://cdn.pixabay.com/photo/2013/07/25/11/58/cricket-166904_1280.jpg");
}
special:button {
background-color: red;
}
</style>
</head>
<body>
<h1 style="text-align: center; color: white;">Welcome to management signup</h1>
<div id="manas">
<h1 style="text-align: center;">Management Signup</h1>
<special:form action="managementsignup" method="post" modelAttribute="management">
<h2>Name: <special:input path="name" /></h2>  
<h2>Pass: <special:input path="password"/></h2><br>
<special:button >Submit</special:button>
</special:form>
</div>
</body>
</html>