<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入struts2 的标签库--%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>ssh测试</title>
    <script src="${pageContext.request.contextPath}/static/javascript/jquery-3.4.1.min.js"></script><!-- 你必须先引入jQuery1.8或以上版本 -->
    <script src="${pageContext.request.contextPath}/static/common/layer/layer.js"></script>

</head>
<body>

${pageContext.request.contextPath}

<%-- 获取值栈中的user对象的uname的值--%>
用户名1： <s:property value="user.uname"></s:property>

<button id="test1">test</button>

<a href="curd" class="layui-btn">CURD</a>

<script>

</script>

</body>
</html>