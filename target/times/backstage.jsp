<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<html>
<head>
    <title>后台首页</title>
    <link rel="stylesheet" href="${sjc}/layui/css/layui.css">
    <link rel="stylesheet" href="${sjc}/css/global.css" media="all">
    <link rel="stylesheet" href="${sjc}/font-awesome/css/font-awesome.min.css">
    <script>
        var sjc = "${sjc}";
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin" style="border-bottom: solid 5px #1aa094;">
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <div class="admin-login-box">
                <a class="logo" style="left: 0;" href="index.jsp">
                    <span style="font-size: 22px;">生机时报</span>
                </a>
            </div>
            <ul class="layui-nav admin-header-item">
                <li class="layui-nav-item">
                    <a href="javascript:;" id="time"></a>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;" class="admin-header-user">
                        <!-- 显示头像 -->
                        <img src="${ROOT.user_image}" />
                        <span>${ROOT.user_name}</span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;"><i class="fa fa-user-circle" aria-hidden="true"></i> 个人信息</a>
                        </dd>
                        <dd>
                            <a href="javascript:;"><i class="fa fa-gear" aria-hidden="true"></i> 设置</a>
                        </dd>

                        <dd>
                            <a href="#"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
                        </dd>
                        <dd id="lock">
                            <a href="javascript:;">
                                <i class="fa fa-lock" aria-hidden="true" style="padding-right: 3px;padding-left: 1px;"></i> 退出系统
                            </a>
                        </dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav admin-header-item-mobile">
                <li class="layui-nav-item">
                    <a href="#"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-side layui-bg-black" id="admin-side">
        <div class="layui-side-scroll" id="admin-navbar-side" lay-filter="side"></div>
    </div>
    <div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
        <div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">
                    <i class="fa fa-dashboard" aria-hidden="true"></i>
                    <cite>控制面板</cite>
                </li>
            </ul>
            <div class="layui-tab-content" style="min-height: 150px; padding: 5px 0 0 0;">
                <div class="layui-tab-item layui-show">
                    <iframe src="${sjc}/mian.jsp"></iframe>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-footer footer footer-demo" id="admin-footer">
        <div class="layui-main">
            <p>
                <!-- 显示当前登陆的账号 -->
                <marquee><a href="#">欢迎您：${ROOT.user_name}</a></marquee>
            </p>
        </div>
    </div>
    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>



    <script type="text/javascript" src="${sjc}/layui/layui.js"></script>
    <script type="text/javascript" src="${sjc}/js/nav1.js"></script>
    <script src="${sjc}/js/backstage.js"></script>
    <script>
        layui.use('layer', function() {
            var $ = layui.jquery,
                layer = layui.layer;

            setInterval(function(){
                var t = new Date();
                var day="";
                switch(t.getDay()){
                    case 1:
                        day="一";
                        break;
                    case 2:
                        day="二";
                        break;
                    case 3:
                        day="三";
                        break;
                    case 4:
                        day="四";
                        break;
                    case 5:
                        day="五";
                        break;
                    case 6:
                        day="六";
                        break;
                    default:
                        day="日";
                        break;
                }
                var html=t.getFullYear()+"年"+(t.getMonth()+1)+"月"+t.getDate()+"日  星期"+day+" "+t.getHours()+":"+t.getMinutes()+":"+t.getSeconds();
                $("#time").html(html);
            },1000);
        });

    </script>
</div>
</body>
</html>