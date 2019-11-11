
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
    <script src="${sjc}/layui/layui.all.js">

    </script>
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
                        <td id="project">管理员登陆</td>
                    </tr>
                    <tr class="line">
                        <td><input type="text" id="account" name="user_account" class="in" placeholder="请输入管理员账号"></td>
                    </tr>
                    <tr class="line">
                        <td><input type="password" id="pwd" name="user_pwd" class="in" placeholder="请输入管理员密码" ></td>
                    </tr>

                    <tr class="line">
                        <td>
                            <button    id="login"  lay-submit=""  class="layui-btn layui-btn-normal"  lay-filter="rlogin"  >登录</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
<script>

$(function () {
    //管理员登陆
    layui.use(['layer', 'form', 'laydate'], function () {
        var layer = layui.layer
            , laydate = layui.laydate
            , form = layui.form
            , $ = layui.jquery;
        form.on('submit(rlogin)', function (data) {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                url: 'user/rootlogin',
                method: 'post',
                data: JSON.stringify(
                    data.field
                ),
                success: function (res) {
                    if (res.status == '0') {
                        layer.msg(res.msg);
                        window.location.href="backstage.jsp";
                    } else
                        layer.msg(res.msg);
                },
                error: function (data) {
                    layer.msg('')
                }
            })
            return false;
        });
    });

})


</script>
</html>