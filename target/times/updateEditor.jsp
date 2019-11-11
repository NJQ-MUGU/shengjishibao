<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>

<html>
<head>
    <title>编辑主编页面</title>
    <link rel="stylesheet" href="${sjc}/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${sjc}/css/table.css">
    <link rel="stylesheet" href="${sjc}/css/global.css" media="all">
    <link rel="stylesheet" href="${sjc}/font-awesome/css/font-awesome.min.css">
    <script>
        var sjc = "${sjc}";
    </script>
</head>
<body>
<div style="margin: 15px;">
    <form class="layui-form" id="form1">
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱：</label>
            <div class="layui-input-block">
                <input type="text" name="user_email" id="user_email" placeholder="请输入"
                       autocomplete="off" class="layui-input" lay-verify="required|email|user_email">

            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称：</label>
            <div class="layui-input-block">
                <input type="text" name="user_name" id="user_name" placeholder="请输入"
                       autocomplete="off" class="layui-input" lay-verify="required|user_name">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别：</label>
            <div class="layui-input-block" id="op_sex" name="op">
                <input type="radio" name="sex" value="男" title="男"/>
                <input type="radio" name="sex" value="女" title="女"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所学专业：</label>
            <div class="layui-input-block">
                <input type="text" name="major_name" id="major_name" placeholder="请输入"
                       autocomplete="off" class="layui-input" lay-verify="major_name">

            </div>
        </div>
        <div class="layui-col-item">
            <label class="layui-form-label">用户类型</label>
            <div class="layui-input-block">
                <select name="state_id" id="state_id">
                    <option value="2">主编</option>
                    <option value="3">用户</option>
                </select>
            </div>
        </div>
        <div class="layui-col-md6">
            <label class="layui-form-label">头像：</label>
            <div class="layui-input-block">
                <select name="photo" lay-filter="photo" id="photo" v-model="iotAssertSensorType.photo">
                    <option value="images/bag.jpg">城市</option>
                    <option value="images/image2.jpg">狗</option>
                    <option value="images/image3.jpg">虎</option>
                    <option value="images/image4.jpg">狮</option>
                </select>

                <img src="images/bag.jpg" name="photoImg" id="photoImg" width="80" height="80"/>
            </div>

        </div>

        <button lay-filter="edit" lay-submit style="display: none;"></button>
    </form>
</div>


<script type="text/javascript" src="${sjc}/layui/layui.js"></script>
<script type="text/javascript" src="${sjc}/layui/layui.all.js"></script>
<script type="text/javascript" src="${sjc}/js/jquery-3.3.1.min.js"></script>
<script>



    layui.use(['layer', 'form'], function () {
        var layer = layui.layer, $ = layui.jquery, form = layui.form;

        var layerTips = parent.layer === undefined ? layui.layer : parent.layer;

        var user_id =
        ${param.user_id}
        if(user_id != null && user_id != "") {
            $.ajax({
                contentType: "application/json; charset=utf-8",
                url: '${sjc}/admin/selectByIdEditor',
                type: "POST",
                data: JSON.stringify({'user_id': user_id}),
                success: function (json) {
                    var obj = json.list;
                    if (json.status == '0') {

                        $("input[name='user_email']").val(obj.user_email);
                        $("input[name='user_name']").val(obj.user_name);
                        $("#user_sex").val(obj.user_sex);
                        $("#major_name").val(obj.major_id.major_name);
                        $("#photo").siblings("div.layui-form-select").find('dl').find('dd[lay-value=' + obj.type + ']').click();
                        var update = $("#form1");
                        update.find("input[type=radio][value='" + obj.user_sex + "']").next().find("i").click();//将value是female的单选框选中
                        update.find("dd[lay-value=value-i-need]").click();
                        //$("input:radio[name=sex]")[男].checked = true;
                        //layui.form.render('radio');
                    }

                },
                error: function (res) {
                    layer.msg(res);
                }
            });
        }

        form.render();
        //监听提交
        form.on('submit(edit)', function (data) {

            var user_id = ${param.user_id};
            var user_name = data.field.user_name;
            var user_sex = data.field.sex;
            var user_image = data.field.photo;
            var state_id = data.field.state_id;
            $.ajax({
                contentType: "application/json; charset=utf-8",
                url: '${sjc}/admin/updateEditor',
                type: "POST",
                data: JSON.stringify({'user_id': user_id, 'user_name': user_name,'user_sex':user_sex,'user_image':user_image,'state_id':{
                        'state_id':state_id
                    }}),
                success: function (json) {
                    layer.msg(json.msg);
                    if (json.status == '0') {
                        layer.open({
                            content: '保存用户信息成功！',
                            yes: function (index, layero) {
                                layerTips.close(index);
                                location.reload(); //刷新
                                layer.close(index);
                            }
                        });
                    }
                },
                error: function (res) {
                    layer.msg(res);
                }
            });

        });

        //绑定下拉框事件
        form.on('select(photo)', function (data) {
            $("#photoImg").prop("src", data.value);
        });


    });


</script>
</body>
</html>
