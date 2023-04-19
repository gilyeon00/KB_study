<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>Connection Pool Test ... Using JNDI Service</h2>
	<%
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracleDB");
		
		out.println("<b>1. datasource lookup .. </b>");
		Connection conn = ds.getConnection();
		out.println("<b><br>2. Connection Rent Success !!!  .. </b>");
	%>
</body>
</html>