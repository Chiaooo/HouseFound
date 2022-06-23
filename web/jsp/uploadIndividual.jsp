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
    <div class="layui-row">

        <form class="layui-form layui-col-md12 x-so" action="${pageContext.request.contextPath}/queryUnit"
              method="post">
            <label>
                <input type="text" name="unitAccNum" autocomplete="off" class="layui-input" placeholder="请输入单位账号">
            </label>
            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <form class="layui-form" action="${pageContext.request.contextPath}/uploadIndividual" method="post">
        <div class="layui-form-item">
            <label for="accName" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="accName" name="accName"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-item">
                <label for="papNo" class="layui-form-label">
                    <span class="x-red">*</span>身份证号码
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="papNo" name="papNo" required
                           lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="baseNumber" class="layui-form-label">
                    <span class="x-red">*</span>缴存基数
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="baseNumber" name="baseNumber" required
                           lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="unitAccNum" class="layui-form-label">
                    <span class="x-red">*</span>单位账号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="unitAccNum" name="unitAccNum" value="${unit.unitAccNum}" readonly
                           lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="unitAccName" class="layui-form-label">
                    <span class="x-red">*</span>单位名称
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="unitAccName" name="unitAccName" value="${unit.unitAccName}" readonly
                           lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="unitProp" class="layui-form-label">
                    <span class="x-red">*</span>单位比例
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="unitProp" name="unitProp" value="${unit.unitProp}" readonly
                           lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="perProp" class="layui-form-label">
                    <span class="x-red">*</span>个人比例
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="perProp" name="perProp" value="${unit.perProp}" readonly
                           lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="unitAgentPapno" class="layui-form-label">
                    <span class="x-red">*</span>经办人身份证号码
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="unitAgentPapno" name="unitAgentPapno"
                           required lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="op" class="layui-form-label">
                    <span class="x-red">*</span>柜员
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="op" name="op"
                           required lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
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
    </form>
</div>
</body>

</html>