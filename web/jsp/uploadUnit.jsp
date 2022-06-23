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
    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/uploadUnit">
        <div class="layui-form-item">
            <label for="unitAccName" class="layui-form-label">
                <span class="x-red">*</span>单位名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="unitAccName" name="unitAccName"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="unitChar" class="layui-form-label">
                <span class="x-red">*</span>单位类别
            </label>
            <div class="layui-input-inline">
                <label>
                    <select name="unitChar">
                        <option value="">类别</option>
                        <c:forEach items="${sessionScope.unitTypeList}" var="unit">
                            <option value="${unit.id}">${unit.typeName}</option>
                        </c:forEach>
                    </select>
                </label>
                <br>
                <br>
            </div>
            <div class="layui-form-item">
                <label for="unitProp" class="layui-form-label">
                    <span class="x-red">*</span>单位比例
                </label>
                <div class="layui-input-inline">
                    <label>
                        <select name="unitProp">
                            <option value="0.05">5</option>
                            <option value="0.06">6</option>
                            <option value="0.07">7</option>
                            <option value="0.08">8</option>
                            <option value="0.09">9</option>
                            <option value="0.10">10</option>
                            <option value="0.11">11</option>
                            <option value="0.12">12</option>
                        </select>
                    </label>
                </div>
                <br>
                <br>
            </div>
            <div class="layui-form-item">
                <label for="perProp" class="layui-form-label">
                    <span class="x-red">*</span>个人比例
                </label>
                <div class="layui-input-inline">
                    <label>
                        <select name="perProp">
                            <option value="0.05">5</option>
                            <option value="0.06">6</option>
                            <option value="0.07">7</option>
                            <option value="0.08">8</option>
                            <option value="0.09">9</option>
                            <option value="0.10">10</option>
                            <option value="0.11">11</option>
                            <option value="0.12">12</option>
                        </select>
                    </label>
                </div>
                <br>
                <br>
            </div>
            <div class="layui-form-item">
                <label for="unitKind" class="layui-form-label">
                    <span class="x-red">*</span>企业类型
                </label>
                <div class="layui-input-inline">
                    <label>
                        <select name="unitKind">
                            <option value="">类型</option>
                            <c:forEach items="${sessionScope.unitKindList}" var="unitKind">
                                <option value="${unitKind.id}">${unitKind.kind}</option>
                            </c:forEach>
                        </select>
                    </label>
                    <br>
                    <br>
                </div>
                <div class="layui-form-item">
                    <label for="unitAddress" class="layui-form-label">
                        <span class="x-red">*</span>单位地址
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="unitAddress" name="unitAddress" required
                               lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="unitLinkMan" class="layui-form-label">
                        <span class="x-red">*</span>经办人
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="unitLinkMan" name="unitLinkMan" value="${unit.unitLinkMan}" required
                               lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="salaryDate" class="layui-form-label">
                        <span class="x-red">*</span>发薪日期
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="salaryDate" name="salaryDate" value="${unit.salaryDate}" required
                               lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="orgCode" class="layui-form-label">
                        <span class="x-red">*</span>组织结构代码
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="orgCode" name="orgCode" value="${unit.orgCode}" required
                               lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="unitPhone" class="layui-form-label">
                        <span class="x-red">*</span>联系电话
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="unitPhone" name="unitPhone" value="${unit.unitPhone}" required
                               lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="unitAgentPapno" class="layui-form-label">
                        <span class="x-red">*</span>经办人身份证号码
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="unitAgentPapno" name="unitAgentPapno" value="${unit.unitAgentPapno}"
                               required lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="op" class="layui-form-label">
                        <span class="x-red">*</span>柜员
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="op" name="op" value="${unit.op}"
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
        </div>
    </form>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
</body>

</html>