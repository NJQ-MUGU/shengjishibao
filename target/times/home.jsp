<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/include/taglib.jsp"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
    <link href="layui/css/layui.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="layui/css/layui.css">
    <link href="layui/css/layui.css" type="text/css" rel="stylesheet" />

    <link rel="stylesheet" href="layui/css/global.css">
    <link rel="stylesheet" href="${sjc}/css/home.css">
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/jiemian/home.js"></script>
    <script src="${sjc}/page/home.js"></script>
    <script src="${sjc}/page/news.js"></script>


</head>
<div class="fly-header" style="background-color:#F0F8FF">

    <div id="conent">

        <ul id="conent_id">
            <li class="conent_li"><a href="">首页</a></li>
            <li class="conent_li"><a href="contribute.jsp">发布</a>
                <%--<div id="content_li_div">--%>
                    <%--<ul id="content_li_ul">--%>
                        <%--<li class="ul_li"><a class="ul_li_a" href="">信息</a></li>--%>
                        <%--<li class="ul_li"><a class="ul_li_a" href="">信息</a></li>--%>
                        <%--<li class="ul_li"><a class="ul_li_a" href="">信息</a></li>--%>
                        <%--<li class="ul_li"><a class="ul_li_a" href="">信息</a></li>--%>
                        <%--<li class="ul_li"><a class="ul_li_a" href="">信息</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>

            </li>
            <%--<li class="conent_li"><a href="">专业</a></li>--%>
            <%--<li class="conent_li"><input id="news"> <a href="">搜索</a></li>--%>
            <c:if test="${user!=null}">
                <li class="layui-nav-item" id="conent_li_img">
                    <img src="${user.user_image}" id="conent_li_img_img"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:;" class="admin-header-user">
                        <!-- 显示头像 -->
                        <span>${user.user_name}</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${user==null}">
              <li class="layui-nav-item" id="conent_li_denglu">

                <a href="login.jsp" id="#conent_li_denglu">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="regist.jsp" class="admin-header-user">注册</a>

                </li>
            </c:if>

        </ul>
    </div>
</div>
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
            <div class="layui-carousel" id="test1">
                <div carousel-item>
                    <div><img src="<%= basePath%>images/1.jpg"></div>
                    <div><img src="<%= basePath%>images/2.jpg"></div>
                    <div><img src="<%= basePath%>images/3.jpg"></div>
                    <div><img src="<%= basePath%>images/4.jpg"></div>
                    <div><img src="<%= basePath%>images/1.jpg"></div>
                </div>
            </div>
            <div class="fly-panel">
                <ul class="fly-list" id="top">

                </ul>
            </div>
        </div>
        <div class="layui-col-md4">
            <dl class="fly-panel fly-list-one" id="heat">
                <dt class="fly-panel-title">本周热议</dt>

                <!-- 无数据时 -->
                <!--
                <div class="fly-none">没有相关数据</div>
                -->
            </dl>
        </div>
    </div>
</div>
    <script src="<%= basePath%>layui/layui.js"></script>
    <script>
        layui.cache.page = '';
        layui.cache.user = {
            username: '游客'
            ,uid: -1
            ,avatar: '../res/images/avatar/00.jpg'
            ,experience: 83
            ,sex: '男'
        };
        layui.config({
            version: "3.0.0"
            ,base: '../res/mods/' //这里实际使用时，建议改成绝对路径
        }).extend({
            fly: 'index'
        }).use('fly');
    </script>

    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_30088308'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/c.php%3Fid%3D30088308' type='text/javascript'%3E%3C/script%3E"));</script>

    </body>
    <script>
        //注意：导航 依赖 element 模块，否则无法进行功能性操作
        layui.use('element', function(){
            var element = layui.element;

            //…
        });
        //轮播
        layui.use('carousel', function(){
            var carousel = layui.carousel;
            //建造实例
            carousel.render({
                elem: '#test1'
                ,height:'140px'
                ,width: '775px' //设置容器宽度
                ,arrow: 'hover' //始终显示箭头
                //,anim: 'updown' //切换动画方式
            });
        });
    </script>

</html>