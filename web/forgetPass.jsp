<%--
  Created by IntelliJ IDEA.
  User: TXJ
  Date: 2017/7/1
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
</head>
<body>
<form action="/ForgetPassServlet" method="post">
使用邮箱找回

 输入邮箱账户：<input type="email" name="email" required="required">
    输入用户密码：<input type="password"  name="password" required="required">
    <input type="submit" value="提交">
    <input type="reset" value="取消">
</form>
</body>
</html>
