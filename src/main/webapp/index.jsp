<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
    <link href="layui/css/layui.css" type="text/css" rel="stylesheet" />
    <script src="${sjc}/js/jquery-1.11.0.min.js"></script>

</head>
<body>
    <ul class="layui-nav" lay-filter="">
         <li class="layui-nav-item"><a href="">最新活动</a></li>
         <li class="layui-nav-item layui-this"><a href="">产品</a></li>
          <li class="layui-nav-item"><a href="">大数据</a></li>
          <li class="layui-nav-item">
            <a href="javascript:;">解决方案</a>
           <dl class="layui-nav-child"> <!-- 二级菜单 -->
             <dd><a href="">移动模块</a></dd>
              <dd><a href="">后台模版</a></dd>
             <dd><a href="">电商平台</a></dd>
           </dl>
          </li>
          <li class="layui-nav-item"><a href="">社区</a></li>
    </ul>

</body>
<script src="layui/layui.js"></script>
<script>

</script>

</html>