<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-10
  Time: 오후 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.* ,mem.*"%>
<jsp:useBean id="mMgr" class="mem.MemberMgr"/>
<!DOCTYPE html>
<html>
<head>
    <title>JSP에서 데이터베이스 연동</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align="center"><br/>
  <h3>회원정보</h3>
  <a href="member.jsp">회원등록</a><br/><br/>
  <table>
    <tr class="title">
      <th>ID</th>
      <th>PASSWD</th>
      <th>NAME</th>
      <th>BIRTHDAY</th>
      <th>EMAIL</th>
      <th>수정</th>
      <th>삭제</th>
    </tr>
    <%
      Vector<MemberBean> mlist = mMgr.getMemberList();
      int counter = mlist.size();
      for(int i=0; i<counter;i++){
        MemberBean bean = mlist.get(i);
      %>
    <tr>
      <td><%=bean.getId()%></td>
      <td><%=bean.getPwd()%></td>
      <td><%=bean.getName()%></td>
      <td><%=bean.getBirthday()%></td>
      <td><%=bean.getEmail()%></td>
      <td><a href="memberModify.jsp?id=<%bean.getId()%>">수정</a></td>
      <td><a href="memberDelete.jsp?id=<%bean.getId()%>"
              onClick="return confirm('<%bean.getName()%>님 회원정보를 정말 삭제하시겠습니까?');">삭제</a></td>
    </tr>
      <%}%>
  </table>
  <br/><br/>
  total records: <%= counter%>
</div>
</body>
</html>
