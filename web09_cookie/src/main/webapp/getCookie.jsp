<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�������� ����� ��� ��Ű�� �޾ƿ´�.</h2>
	<!-- Sciptlet Element : html�� �ƴ� java �ڵ常  -->
	<!-- Expression Element : ��¹�, ;���̸� �ȵ�  -->
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