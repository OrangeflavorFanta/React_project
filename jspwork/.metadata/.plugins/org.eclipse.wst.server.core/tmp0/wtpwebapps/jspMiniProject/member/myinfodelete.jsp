<%@page import="data.Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Gaegu&family=Gowun+Batang&family=Hi+Melody&family=Noto+Serif+KR:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	String num=request.getParameter("num");
	
	//전체멤버 정보 가져오기
	MemberDao dao=new MemberDao();
	
	dao.deleteInfo(num);
	
	//세션
	session.removeAttribute("loginok");
	session.removeAttribute("myid");
	
	response.sendRedirect("../index.jsp?main=login/loginmain.jsp");
	%>
</body>
</html>
