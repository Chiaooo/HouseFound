<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>住房公积金管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
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
<div class="x-body">
    <form class="layui-form" action="${pageContext.request.contextPath}/updateIndividual" method="post">
        <input type="hidden" name="accNum" value="${accNum}">
        <div class="layui-form-item">
            <label for="accName" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="accName" name="accName" value="${individual.accName}"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-item">
                <label for="papNo" class="layui-form-label">
                    <span class="x-red">*</span>身份证号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="papNo" name="papNo" value="${individual.papNo}" required
                           lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="unitAccNum" class="layui-form-label">
                    <span class="x-red">*</span>单位账号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="unitAccNum" name="unitAccNum" value="${individual.unitAccNum}" disabled
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="unitAccName" class="layui-form-label">
                    <span class="x-red">*</span>单位名称
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="unitAccName" name="unitAccName" value="${individual.unitAccName}" disabled
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label for="remark" class="layui-form-label">
                        <span class="x-red">*</span>备注
                    </label>
                    <div class="layui-input-inline">
                        <textarea cols="25" rows="5" class="layui-textarea" id="remark"
                                  name="remark"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                    </label>
                    <button class="layui-btn" lay-filter="add" lay-submit="">
                        提交
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>

</html>