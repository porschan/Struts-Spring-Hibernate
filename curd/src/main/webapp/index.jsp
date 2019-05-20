<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入struts2 的标签库--%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>ssh测试</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/common/layerui/css/layui.css" media="all">
</head>
<body>

当前项目：
${pageContext.request.contextPath}
<br>

<%-- 获取值栈中的user对象的uname的值--%>
<%--用户名1： <s:property value="user.uname"></s:property>--%>


<a href="curdPage" class="layui-btn">CURD</a>

<a href="filePage" class="layui-btn">file</a>

<script>

</script>

</body>
</html>