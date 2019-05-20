<%--
  Created by IntelliJ IDEA.
  User: porschan
  Date: 2019/5/20
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 注意！表单必须添加 enctype 属性，值为"multipart/form-data" -->
<form action="upload.action" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="上传"/>
</form>
</body>
</html>
