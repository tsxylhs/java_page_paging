<%@ page language="java" contentType="text/html; charset=UTF-8"
        import="cn.lhs.dao.book"   pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style type="text/css">
th,td{width: 150px;border: 2px solid gray;text-align: center;}
body{text-align: center;}
a{text-decoration: none;}
table {border-collapse: collapse;}
</style>
</head>
<body>
<h2 align="center">图书管理系统</h2>
<h4 align="center"><a href="add.jsp">添加图书</a></h4>
<table align="center">
   <tr><td>书号</td><td>书名</td><td>作者</td></tr>    
</table>
<table align="center">
<c:forEach items="${listss}" var="book">
<tr>
<td class="hidden-480">${book.bookID}</td>
<td class="hidden-480">${book.bookName}</td>
<td class="hidden-480">${book.autherName}</td>
<td><a href="listbookservlet?delete=${book.bookID}">删除</a></td>
</tr>
</c:forEach>
</table>
<br>
<c:if test="${pageNos>1 }">
<a href="listbookservlet?pageNos=1">首页</a>
<a href="listbookservlet?pageNos=${pageNos-1}">上一页</a>
</c:if>
<c:if test="${pageNos<recordCount}">
<a href="listbookservlet?pageNos=${pageNos+1 }">下一页</a>
<a href="listbookservlet?pageNos=${recordCount}">未页</a>
</c:if>
<form action="listbookservlet">
<h4 align="center">共${recordCount}页  
<input type="text" value="${pageNos}" name="pageNos" size="1">页
<input type="submit" value="到达">
</h4>
</form>
</body>
</html>