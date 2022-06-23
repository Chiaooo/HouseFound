<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-L-admin1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagebox.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">

      <span class="layui-breadcrumb">
        <a href="">单位查询</a>
        <a href="">单位查询</a>
        <a>
          <cite>管理面板</cite></a>
      </span>

    <a class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i>
    </a>

</div>


<div class="x-body">
    <div class="layui-row">

        <form class="layui-form layui-col-md12 x-so" action="${pageContext.request.contextPath}/getUnit" method="post">
            <div class="layui-input-inline">
                <select name="unitChar">
                    <option value="">类别</option>
                    <c:forEach items="${sessionScope.unitTypeList}" var="unit">
                        <option value="${unit.id}">${unit.typeName}</option>
                    </c:forEach>
                </select>
            </div>
            <label>
                <input type="text" name="unitAccName" autocomplete="off" class="layui-input" placeholder="请输入单位名称或账号">
            </label>
            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
</div>


<table class="layui-table" style="text-align: center">
    <thead>
    <tr>
        <th style="text-align: center">
            <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                    class="layui-icon">&#xe605;</i></div>
        </th>
        <th style="text-align: center">单位账号</th>
        <th style="text-align: center">名称</th>
        <th style="text-align: center">地址</th>
        <th style="text-align: center">账户状态</th>
        <th style="text-align: center">缴存基数</th>
        <th style="text-align: center">公积金余额</th>
        <th style="text-align: center">单位月缴</th>
        <th style="text-align: center">个人月缴</th>
        <th style="text-align: center">单位人数</th>
        <th style="text-align: center">开户柜员</th>
        <th style="text-align: center">操作</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="unit" items="${pageInfo.list}" varStatus="i">
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i
                        class="layui-icon">&#xe605;</i></div>
            </td>


            <td>${unit.unitAccNum}</td>
            <td>${unit.unitAccName}</td>
            <td>${unit.unitAddress}</td>
            <td>
                <c:if test="${unit.accState==9}"><font color="#dc143c">销户</font>
                </c:if>
                <c:if test="${unit.accState==0}"><font color="#228b22">正常</font>
                </c:if>
            </td>
            <td>${unit.baseNumber}</td>
            <td>${unit.balance}</td>
            <td>${unit.unitPaySum}</td>
            <td>${unit.perPaySum}</td>
            <td>${unit.persNum}</td>
            <td>${unit.op}</td>
            <td class="td-manage">
                <a href="${pageContext.request.contextPath}/delUnit/${unit.unitAccNum}">
                    <button class="layui-btn-danger layui-btn layui-btn-xs" type="submit"
                            onclick="return confirm('确定要销户吗？')">
                        销户
                    </button>
                </a>
                <a href="${pageContext.request.contextPath}/toUpdateUnitPage/${unit.unitAccNum}">
                    <button class="layui-btn layui-btn layui-btn-xs" type="submit">
                        修改
                    </button>
                </a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div id="pageBox" class="layui-laypage-btn" align="center" style="margin-top: 20px">
    <span class="layui-laypage-btn">共${pageInfo.total}条记录</span>
    <span class="layui-laypage-btn">当前${pageInfo.pageNum}/${pageInfo.pages }页</span>
    <a class="layui-laypage-btn" href="
${pageContext.request.contextPath}/unitList.html?pageNum=1">首页</a>
    <a class="layui-laypage-btn"
       href="${pageContext.request.contextPath}/unitList.html?pageNum=${pageInfo.hasPreviousPage?pageInfo.prePage:1}">上一页</a>
    <a class="layui-laypage-btn"
       href="${pageContext.request.contextPath}/unitList.html?pageNum=${pageInfo.hasNextPage?pageInfo.nextPage:pageInfo.pages}">下一页</a>
    <a class="layui-laypage-btn"
       href="${pageContext.request.contextPath}/unitList.html?pageNum=${pageInfo.pages}">尾页</a>
</div>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });
</script>
</body>

</html>
