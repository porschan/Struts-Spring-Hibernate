<%--
  Created by IntelliJ IDEA.
  User: porschan
  Date: 2019/5/17
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user_register.action" method="post">
    姓名: <input name="name" type="text"> <br>
    密码:<input name="password" value="1234" type="password">
    性别: <input name="sex" type="radio" value="1">男
    &nbsp;&nbsp; <input name="sex" type="radio" value="0">女
    <input type="submit" value="注册">
</form>
</body>
</html>
