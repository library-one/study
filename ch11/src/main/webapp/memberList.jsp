<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="java.util.*, mem.*" %>
<jsp:useBean id="mMgr" class="MemberMgr"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp���� �����ͺ��̽� ����</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align="center">
<br/>
<h3>ȸ������</h3>
<a href="member.jsp">ȸ�����</a><br/><br/>
<table>
<tr class="title">
	<th>ID</th>
	<th>PASSWD</th>
	<th>NAME</th>
	<th>birthday</th>
	<th>Email</th>
	<th>����</th>
	<th>����</th>
</tr>
<%
	Vector<MemberBean> vlist = mMgr.getMemberList();
	int counter = vlist.size();
	for(int i=0; i<counter;i++){
		MemberBean bean = vlist.get(i);
%>
<tr>
	<td><%=bean.getId()%></td>
	<td><%=bean.getPwd()%></td>
	<td><%=bean.getName()%></td>
	<td><%=bean.getBirthday()%></td>
	<td><%=bean.getEmail()%></td>
	<td><a href="memberModify.jsp?id=<%=bean.getId()%>">����</a></td>
	<td><a href="memberDelete.jsp?id=<%=bean.getId()%>"
			onClick="return confirm('<%=bean.getName()%>�� ȸ�������� ���� �����Ͻðڽ��ϱ�?');">����</a></td>
	</tr>
	<%}%>
</table>
<br/><br/>
total records : <%=counter%>
</div>
</body>
</html>