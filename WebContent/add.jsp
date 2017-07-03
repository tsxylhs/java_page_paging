<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
      <h1>添加图书</h1>
      
     <form action="addbookservlet" method="post">
      书号:<input type="text" name="bookID"><br>
      书名：<input type="text" name="bookName"><br>
      作者：<input type=text" name="autherName"><br>
      <input type="submit" value="添加书籍">
      
     
     </form>
</div>

</body>
</html>