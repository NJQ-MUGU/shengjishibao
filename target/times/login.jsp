
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登陆页面</title>
    <link href="${sjc}/layui/css/layui.css" type="text/css" rel="stylesheet" />
    <script src="${sjc}/js/jquery-1.11.0.min.js"></script>
    <script src="${sjc}/js/user.js"></script>
    <script src="${sjc}/layui/layui.js"></script>
    <script src="${sjc}/layui/layui.all.js"></script>
    <link href="${sjc}/css/login.css" type="text/css" rel="stylesheet" />

</head>
<body>
    <div id="all">
        <div id="all_left">
            <img src="images/bag.png" id="all_left_img" width="100%" height="100%">
        </div>
        <div id="all_right">
            <form  class="layui-form" action="" id="lo">
                <table id="table">
                    <tr class="line project">
                        <td id="project">生机时报</td>
                    </tr>
                    <tr class="line">
                        <td><input type="text" id="account" name="user_email" class="in" placeholder="请输入邮箱"></td>
                    </tr>
                    <tr class="line">
                        <td><input type="password" id="pwd" name="user_pwd" class="in" placeholder="请输入密码" ></td>
                    </tr>
                    <tr class="line">
                        <td>
                            <a href="forget.jsp" data-opt="edit" id="nopwd" class="hr">忘记密码</a>
                            <a href="regist.jsp" data-opt="edit" id="regist" class="hr">注册账号</a>
                        </td>
                    </tr>
                    <tr class="line">
                        <td>
                            <button    id="login"  lay-submit=""  class="layui-btn layui-btn-normal"  lay-filter="login"  >登录</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>