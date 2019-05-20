<%@ page import="com.chanchifeng.model.User" %><%--
  Created by IntelliJ IDEA.
  User: porschan
  Date: 2019/5/19
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form action="update.action" method="post">
    <%
        User user = (User) request.getAttribute("user");
    %>
    <p>
        <label>姓名：</label>
        <input type="text" name="uname" value="<%= user.getUname()%>" id="name"/>
    </p>
    <p>
        <input type="hidden" name="uid" value="<%= user.getUid()%>" id="id"/>
        <input type="submit" value="修改">
    </p>
</form>
</body>
</html>
