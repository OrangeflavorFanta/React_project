<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Gaegu&family=Gowun+Batang&family=Hi+Melody&family=Noto+Serif+KR:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<title>Insert title here</title>
</head>
<body>

	<%
	//세션에 저장된 loginok를 읽는다
	String loginok=(String)session.getAttribute("loginok");
	
	if(loginok==null)//로그아웃
	{%>
		<jsp:include page="loginform.jsp"/>
		
	<%}else{%>
		<jsp:include page="logoutform.jsp"/>
	<%}
	%>
	
	
	

</body>
</html>