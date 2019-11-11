<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<html>
<head>
    <title>控制面板</title>
    <link rel="stylesheet" href="${sjc}/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${sjc}/css/main.css" />
    <script>
        var sjc = "${sjc}";
    </script>
</head>
<body>
<!-- 控制面板 -->
<div class="admin-main">
    <blockquote class="layui-elem-quote">
        <p>生机时报管理系统欢迎您！</p>
        <br/>
        <p style="color: #01AAED;"></p>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>模块划分</legend>
        <div class="layui-field-box">
            <fieldset class="layui-elem-field layui-field-title">
                <div class="layui-field-box">
                    <p>1、用户管理：主编管理，普通用户管理</p>
                    <p>2、时报管理</p>
                </div>
            </fieldset>

        </div>
    </fieldset>
</div>

</body>
</html>