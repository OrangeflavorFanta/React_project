<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="ajaxboard.model.AjaxBoardDto"%>
<%@page import="ajaxboard.model.AjaxBoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//num
	String num=request.getParameter("num");

	//dao
	AjaxBoardDao dao=new AjaxBoardDao();
	
	//dto
	AjaxBoardDto dto=dao.getData(num);
	
	//dto�� json ��ȯ
	JSONObject ob=new JSONObject();
	
	//��¥Ÿ�� ���ڿ� ����
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//json�� ������ �߰��ϱ�	
	ob.put("num",dto.getNum());
	ob.put("writer",dto.getWriter());
	ob.put("subject",dto.getSubject());
	ob.put("content",dto.getContent());
	ob.put("avata",dto.getAvata());
	ob.put("writeday",sdf.format(dto.getWriteday()));
	

%>
<%=ob.toString()%>