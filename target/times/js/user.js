// 登陆提交表单
$(function () {
    layui.use(['layer', 'form', 'laydate'], function () {
        var layer = layui.layer
            , laydate = layui.laydate
            , form = layui.form
            , $ = layui.jquery;
        form.on('submit(login)', function (data) {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                url: 'user/login',
                method: 'post',
                data: JSON.stringify(
                    data.field
                ),
                success: function (res) {
                    if (res.status == '0') {
                        layer.msg(res.msg);
                        window.location.href="home.jsp";
                    } else
                        layer.msg(res.msg);
                },
                error: function (data) {
                    layer.msg(异常)
                }
            })
            return false;
        });
    });
});

// 忘记密码提交表单
$(function () {
    layui.use(['layer', 'form', 'laydate'], function () {
        var layer = layui.layer
            , laydate = layui.laydate
            , form = layui.form
            , $ = layui.jquery;
        form.on('submit(forget)', function (data) {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                url: 'user/forget',
                method: 'post',
                data: JSON.stringify(
                    data.field
                ),
                success: function (res) {
                    if (res.status == '0') {
                        $('#checkemail').val(res.list);
                        $('#forget').css('display','none');
                        $('#change').css('display','block');
                    } else
                        layer.msg(res.msg)
                },
                error: function (data) {
                    layer.msg(异常)
                }
            })
            return false;
        });
    });
});
// 修改密码提交表单
$(function () {
    layui.use(['layer', 'form', 'laydate'], function () {
        var layer = layui.layer
            , laydate = layui.laydate
            , form = layui.form
            , $ = layui.jquery;
        form.on('submit(update)', function (data) {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                url: 'user/update_pwd',
                method: 'post',
                data: JSON.stringify(
                    data.field
                ),
                success: function (res) {
                    if (res.status == 0) {
                        layer.msg(res.msg)
                        window.location.href="login.jsp"
                    } else
                        layer.msg(res.msg)
                },
                error: function (data) {
                    layer.msg(异常)
                }
            })
            return false;
        });
    });
});

//注册提交表单
$(function () {
    layui.use(['layer', 'form', 'laydate'], function () {
        var layer = layui.layer
            , laydate = layui.laydate
            , form = layui.form
            , $ = layui.jquery;
        form.on('submit(regist)', function (data) {
            layer.msg("123123")
            $.ajax({
                contentType: "application/json; charset=utf-8",
                url: 'user/regist',
                method: 'post',
                data: JSON.stringify(
                    data.field
                ),
                success: function (res) {
                    if (res.status == 0) {
                        layer.msg(res.msg);
                        window.location.href="login.jsp"

                    } else
                        layer.msg(res.msg);
                },
                error: function (data) {
                    layer.msg("异常");
                }

            })
            return false;

        });
    });


})

//发送邮箱验证码
function check_email(forget) {
    var email = $('#email').val();
    if (email.trim().length == 0) {
        layer.msg("请输入邮箱")
        return false;
    }

    //邮箱中必须出现@符号和点号
    if (email.indexOf('@') == -1 || email.indexOf('.') == -1) {
        layer.msg("邮箱中必须出现@符号和点号");
        return false;
    }
    //点号在@符号后面
    if (email.indexOf('.') < email.indexOf('@')) {
        layer.msg("邮箱格式不正确")
        return false;
    }
    $.ajax({
        contentType: "application/json; charset=utf-8",
        type: "POST",
        url: "user/check_email",
        data: JSON.stringify({
            "user_email": email,
            "code":forget
        }),
        dataType: 'json',
        success: function (result) {
            if (result.status == 0) {
                layer.msg(result.msg)
            } else {
                layer.msg(result.msg)
            }
        }
    });

}

