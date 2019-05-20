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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/common/layerui/css/layui.css" media="all">
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

<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>编号</th>--%>
<%--        <th>姓名</th>--%>
<%--        <th>操作</th>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        for(User user:(List<User>) request.getAttribute("users")){--%>
<%--    %>--%>

<%--    <tr>--%>
<%--        <td><%= user.getUid()%></td>--%>
<%--        <td><%= user.getUname()%></td>--%>
<%--        <td>--%>
<%--            <a href="delete.action?uid=<%= user.getUid()%>">删除</a> |--%>
<%--            <a href="queryById.action?uid=<%= user.getUid()%>">修改</a>--%>
<%--        </td>--%>
<%--    </tr>--%>

<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--</table>--%>

<hr>
layerUI - jquery

条件搜索：
uanme:<input type="text" id="uname" value="">
uid:<input type="text" id="uid"  value="">

<table id="demo" lay-filter="test"></table>

<script src="${pageContext.request.contextPath}/static/javascript/jquery-3.4.1.min.js"></script><!-- 你必须先引入jQuery1.8或以上版本 -->
<script src="${pageContext.request.contextPath}/static/common/layerui/layui.js"></script>

<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height:510
            ,url: 'curd_findAllJSON' //数据接口
            ,where:{
                uname:$("#uname").val()
                ,uid:$("#uid").val()
            }
            ,response: {
                countName:'totalRecord'
                ,dataName: 'dataList'
                ,statusName: 'status'
            }
            ,page: true //开启分页
            ,limit: 10
            ,cols: [[ //表头
                {field: 'uid', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'uname', title: '用户名', width:80}

                ,{field:'title', title: '文章标题', width: 150
                    ,templet: function(d){
                        return '<a class="layui-btn layui-btn-sm layui-btn-danger" href="delete.action?uid=' + d.uid + '">删除</a>' +
                            '<a class="layui-btn layui-btn-sm layui-btn-normal" href="queryById.action?uid=' + d.uid + '">修改</a>'
                    }
                }

                // ,{field: 'sex', title: '性别', width:80, sort: true}
                // ,{field: 'city', title: '城市', width:80}
                // ,{field: 'sign', title: '签名', width: 177}
                // ,{field: 'experience', title: '积分', width: 80, sort: true}
                // ,{field: 'score', title: '评分', width: 80, sort: true}
                // ,{field: 'classify', title: '职业', width: 80}
                // ,{field: 'wealth', title: '财富', width: 135, sort: true}
            ]]
        });

    });
</script>


</body>
</html>