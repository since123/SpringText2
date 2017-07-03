<%--
  Created by IntelliJ IDEA.
  User: TXJ
  Date: 2017/6/28
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<body>
<form  action="/RegisterServlet" method="post">
姓名：<input type="text" name="username" required="required" /><br/>
密码：<input type="password" name="password" required="required"/><br/>
住址：<input type="text" name="address" required="required"/><br/>
电话号码：<input type="tel" name="phone" required="required"/><br/>
    <input type="submit" value=" 提交" onclick="return check(this.form)"/>
    <input type="reset" value="全部取消">
</form>
<script>
    function check(form)
    {
        var password=/^[0-9a-zA-Z]{6,15}$/;
        if(!password.test(form.password.value))
        {
            alert("密码长度必须大于5位小于16位，只能由数字和字母组成");
            return false;
        }
        var phone=/\d{11}/;
        if(!phone.test(form.phone.value))
        {
            alert("电话号码只能为11位，请重新输入！");
            return false;
        }
        return 1;
    }
</script>
</body>
</html>
