<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>브라우저에 저장된 모든 쿠키를 받아온다.</h2>
	<!-- Sciptlet Element : html이 아닌 java 코드만  -->
	<!-- Expression Element : 출력문, ;붙이면 안됨  -->
	<%
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
	%>
			<li> Name <%= c.getName() %></li>
			<li> Value <%= c.getValue() %></li>
			
	<% 
		}
	
	%>
</body>
</html>