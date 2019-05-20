<%@ page import="com.chanchifeng.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: porschan
  Date: 2019/5/19
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
实现CURD

<h1>添加</h1>
<form action="add.action" method="post">
    <p>
        <label>姓名：</label>
        <input type="text" name="uname" id="name"/>
    </p>
    <p>
        <input type="submit" value="添加">
    </p>
</form>

<table border="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>操作</th>
    </tr>
    <%
        for(User user:(List<User>) request.getAttribute("users")){
    %>

    <tr>
        <td><%= user.getUid()%></td>
        <td><%= user.getUname()%></td>
        <td>
            <a href="delete.action?uid=<%= user.getUid()%>">删除</a> |
            <a href="queryById.action?uid=<%= user.getUid()%>">修改</a>
        </td>
    </tr>

    <%
        }
    %>
</table>
</body>
</html>