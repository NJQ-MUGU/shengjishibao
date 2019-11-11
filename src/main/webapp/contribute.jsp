<%--
  Created by IntelliJ IDEA.
  User: 申
  Date: 2019/6/5
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${sjc}/layui/css/layui.css" type="text/css" rel="stylesheet"/>
    <script src="${sjc}/js/jquery-1.11.0.min.js"></script>

    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<p id="user_id" >${user.user_id}</p>
<div style="margin-top: 20px;width: 70%;margin-left: 15%">


    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>投稿页面</legend>
    </fieldset>
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">新闻标题</label>
            <div class="layui-input-inline">
                <input id="news_title" name="news_title" class="layui-input" type="text" placeholder="请输入主标题" autocomplete="off"
                       lay-verify="title">


            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">副标题</label>
            <div class="layui-input-inline">
                <input id="news_subtitle" name="news_subtitle" class="layui-input" type="text" placeholder="请输入副标题" autocomplete="off"
                       lay-verify="required">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input id="news_remarks" name="news_remarks" class="layui-input" type="text" placeholder="请输入备注" autocomplete="off">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">投稿专业</label>
            <div class="layui-input-block">
                <select name="major" id="major" lay-filter="aihao">
                    <option value=""></option>
                </select>
            </div>
        </div>


        <div class="layui-form-item" pane="">
            <label class="layui-form-label">关于转载</label>
            <div class="layui-input-block">
                <input class="radio" name="news_isreprint" title="允许" type="radio" checked="" value="true">
                <input class="radio" name="news_isreprint" title="不允许" type="radio" value="false">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文本域</label>
            <div class="layui-input-block">
                <textarea name="content" class="layui-textarea" lay-verify="content" id="dome" placeholder="请输入内容"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn" lay-filter="dome2" lay-submit="">提交审核</button>
        </div>
    </form>
</div>

<script src="layui/layui.js"></script>
<script>
    //获取各大专业
    $(function () {
        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "GET",
            url: "major/getmajor",
            data: {},
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.status == 0) {
                    $('#major').empty();
                    var a;
                    $.each(result.list, function(i,val){
                        a = a+'<option value="'+val.major_id+'">'+val.major_name+'</option>';
                    });
                    $('#major').append(a)
                    $('#major').selectpicker('refresh');
                    $('#major').selectpicker('render');

                }
            }
        });

    });

</script>



<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        var index;

        form.on('submit(dome2)', function (data) {

           $.ajax({
                contentType: "application/json; charset=utf-8",
                url: 'news/contribute',
                method: 'post',
                data: JSON.stringify(  {
                        "news_title": data.field.news_title,
                        "news_subtitle": data.field.news_subtitle,
                        "news_remarks":data.field.news_remarks,
                        "news_isreprint":data.field.news_isreprint,
                        "news_content":   data.field.content,

                        "major_id":{
                            "major_id" :data.field.major
                        },
                    "user_id":{
                        "user_id" : $("#user_id").html()
                    }
                    }),
                success: function (res) {
                    if(res.status == 0){
                        layer.msg(res.msg);
                        window.location.href("home.jsp");
                    }

                },
                error: function (data) {
                    layer.msg("异常");
                }

            })
            return false;

        });



        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });



        layui.use('layedit', function () {
            var layedit = layui.layedit;
            layedit.set({
                uploadImage: {
                    url: 'uploadFile' //接口url
                    , type: 'post' //默认post
                }
            });
           index = layedit.build('dome'); //建立编辑器
        });

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }

            , content: function (value) {
                layedit.sync(index);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function (data) {
            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });



    });
</script>

</body>
</html>
