<%--
  Created by IntelliJ IDEA.
  User: TXJ
  Date: 2017/6/27
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/LoginServlet" method="post">
    姓名：<input type="text" name="name"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit"><br/>
    <a href="forgetPass.jsp">忘记密码</a><br/>
    <a href="register.jsp">注册</a>
</form>
</body>
</html>
