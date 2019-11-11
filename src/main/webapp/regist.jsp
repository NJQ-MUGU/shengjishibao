<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册界面</title>
    <link href="${sjc}/layui/css/layui.css" type="text/css" rel="stylesheet" />
    <script src="${sjc}/js/jquery-1.11.0.min.js"></script>
    <script src="${sjc}/layui/layui.js"></script>
    <script src="${sjc}/js/user.js"></script>
    <link href="${sjc}/css/regist.css" type="text/css" rel="stylesheet" />
    <script>
        var sjc = "${sjc}";
    </script>
</head>
<body>
        <div id="all">
                <div id="all_left">
                    <img src="images/bag.png" id="all_left_img" width="100%" height="100%">
                </div>
                <div id="all_right">
                    <form  class="layui-form" action="">
                        <table id="table">
                            <tr class="line project">
                                <td id="project">生机时报</td>
                            </tr>
                            <tr class="line">
                                <td><input type="text" id="user_name" name="user_name" class="in" placeholder="请输入用户昵称"></td>
                            </tr>
                            <tr class="line">
                                <td><input type="email" id="email" name="user_email" class="in" placeholder="请输入邮箱" ></td>
                            </tr>
                            <tr class="line">
                                <td><input type="password" id="user_pwd" name="user_pwd" class="in" placeholder="请输入密码" ></td>
                            </tr>
                            <tr class="line">
                                <td>
                                    <input type="text" id="code" name="code" placeholder="请输入验证码" >
                                    <span data-opt="edit" onclick="javascript:check_email();" id="code_btn" class="layui-btn layui-btn-sm layui-btn-normal">点击发送验证码</span>
                                </td>
                            </tr>
                            <tr class="line">
                                <td>
                                    <a href="login.jsp" data-opt="edit"  class="hr">已有账号点击登录</a>
                                </td>
                            </tr>
                            <tr class="line">
                                <td>
                                    <button  lay-submit=""  class="layui-btn layui-btn-normal" lay-filter="regist"   >注册</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
</div>
</body>
</html>