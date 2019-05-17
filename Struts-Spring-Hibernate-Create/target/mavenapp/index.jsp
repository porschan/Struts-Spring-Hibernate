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
    <title>首页</title>
</head>
<body>
url:${pageContext.request.contextPath}
<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
<a href="${pageContext.request.contextPath}/register.jsp">注册</a><br>
</body>
</html>
