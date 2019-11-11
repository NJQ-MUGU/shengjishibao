<%--
  Created by IntelliJ IDEA.
  User: 木古
  Date: 2019/5/31
  Time: 1:18
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="js/jquery-1.11.0.min.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="layui/css/global.css">
    <link rel="stylesheet" href="${sjc}/css/news.css">
    <script src="page/home.js"></script>
    <script src="page/news.js"></script>
    <script src="layui/layui.js"></script>

    <title>新闻详情</title>
</head>
<body>
<div id="all">
    <div id="left">
        <div id="left_content">
            <h2 id="news_title"></h2>
            <div id="left_dongtai">
                <a class="layui-badge" id="mojor_name"></a>
                <span class="dongtai" id="news_date"></span>
                <i class="dongtai" title="回答" id="news_browse"><img src="images/huida.png"> </i>
            </div>
            <hr style="color:#000000;width: 100%;">
            <span>来源：</span><span id="span_name"></span>
            <div id="div_content">
                <p class="p_content" id="p1">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </p>

            </div>
        </div>
        <div class="layui-collapse">
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">评论</h2>
                <div class="layui-colla-content layui-show">
                    <ul class="jieda" id="jieda">


                        <!-- 无数据时 -->
                        <!-- <li class="fly-none">消灭零回复</li> -->
                    </ul>
                    <div class="layui-form layui-form-pane">
                    <form class="layui-form" action="" method="post" id="addEmployeeForm">
                        <div class="layui-form-item layui-form-text">
                            <a name="comment"></a>
                            <div class="layui-input-block">
                                <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <input type="hidden" name="jid" value="123">
                            <button class="layui-btn" lay-filter="huifu" lay-submit>提交回复</button>
                        </div>
                    </form>
                </div>
                </div>
            </div>
        </div>
    </div>

    <div id="right">
        <hr style="width: 100%; height: 3px; color:red;margin-top: -10px">
        <div id="right_conent">
            <h3>咨询推荐</h3>
            <ul id="right_ul">
                <%--<li class="right_li">
                    <img src="images/1.jpg" style="width: 100%;height: 100px;">
                    <a href="" class="right_ul_li_a"><span>1. </span>王建林29亿出售美国加州地块</a>
                    <hr style="width: 90%;color: #000;">
                </li>
                <li class="right_li">
                    <img style="display: none;" src="images/1.jpg" style="width: 100%;height: 100px;">
                    <a href="" class="right_ul_li_a"><span>2. </span>王建林29亿出售美国加州地块</a>
                    <img src="images/1.jpg" style="width: 100%;height: 100px;">
                </li>--%>
            </ul>
        </div>
    </div>
</div>
</body>

</html>
