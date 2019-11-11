
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
    <link href="${sjc}/css/forget.css" type="text/css" rel="stylesheet" />

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
            <form  class="layui-form" action=""  id="forget" >
                <table id="table">
                    <tr class="line project">
                        <td id="project">生机时报</td>
                    </tr>
                    <tr class="line">
                        <td><input type="email" id="email" name="user_email" class="in" placeholder="请输入邮箱" ></td>
                    </tr>

                    <tr class="line">
                        <td>
                            <input type="text" id="code" name="code" placeholder="请输入邮箱验证码" >
                            <span data-opt="edit" onclick="javascript:check_email(123);" id="code_btn" class="layui-btn layui-btn-sm layui-btn-normal">点击发送验证码</span>
                        </td>
                    </tr>
                    <tr class="line">
                        <td>
                            <a href="login.jsp" data-opt="edit"  class="hr">已有账号点击登录</a>
                        </td>
                    </tr>
                    <tr class="line">
                        <td>
                            <button    id="login"  lay-submit=""  class="layui-btn layui-btn-normal"  lay-filter="forget"  >修改密码</button>
                        </td>
                    </tr>
                </table>
            </form>
            <form  class="layui-form" action=""  id="change" style="display:none;" >
                <table id="table2">
                    <tr class="line project">
                        <td id="project2">生机时报</td>
                    </tr>
                    <tr class="line">
                        <td><input class="in" type="text" name ="user_email" id="checkemail" readonly="readonly"></td>
                    </tr>
                    <tr class="line">
                        <td><input type="password" id="pwd" name="user_pwd" class="in" placeholder="请输入新密码" ></td>
                    </tr>
                    <tr class="line">
                        <td>
                            <a href="login.jsp" data-opt="edit"  class="hr">已有账号点击登录</a>
                        </td>
                    </tr>
                    <tr class="line">
                        <td>
                            <button    id="login2"  lay-submit=""  class="layui-btn layui-btn-normal"  lay-filter="update"  >确定</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>