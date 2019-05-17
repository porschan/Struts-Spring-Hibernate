<%--
  Created by IntelliJ IDEA.
  User: porschan
  Date: 2019/5/17
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    姓名: <input name="name" type="text"> <br>
    <input type="submit" value="登录">

</form>
</body>
</html>
