<%--
  Created by IntelliJ IDEA.
  User: TXJ
  Date: 2017/6/26
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传实例-菜鸟教程</title>
</head>
<body>
<h1>文件上传实例-菜鸟教程</h1>
<form action="/UploadServlet" method="post" enctype="multipart/form-data">
    选择一个文件：
    <input type="file" name="uploadFile" />
<br/><br/>
<input type="submit" value="上传">
</form>
</body>
</html>
