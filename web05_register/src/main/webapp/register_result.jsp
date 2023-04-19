
<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--  Attribute에 바인딩된 dto 객체를 받아온다 -->    
<% Member dto = (Member) request.getAttribute("dto"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>
	<h2><b><%=request.getParameter("name") %></b>님, 회원가입에 성공했습니다.</h2>
	<hr>
	NAME <%= dto.getName() %>
	ADDRESS <%= dto.getAddress() %>
</body>
</html>