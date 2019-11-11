<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>

<html>
<head>
    <title>查询主编页面</title>
    <link rel="stylesheet" href="${sjc}/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${sjc}/css/table.css">
    <link rel="stylesheet" href="${sjc}/css/global.css" media="all">
    <link rel="stylesheet" href="${sjc}/font-awesome/css/font-awesome.min.css">

    <script>
        var sjc = "${sjc}";
    </script>
</head>
<body>
<div class="admin-main">

    <blockquote class="layui-elem-quote">
        <form class="layui-form" action="">
            <label>主编姓名：</label>
            <!-- <input type="text" name="teacherName" /> -->
            <div class="layui-input-inline" style="width:150px;">
                <input type="text" name="editorName" id="editorName" placeholder="请输入" autocomplete="off"
                       class="layui-input">
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <a href="javascript:;" class="layui-btn layui-btn-small" id="search">
                <i class="layui-icon">&#xe615;</i> 搜索
            </a>
        </form>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>主编信息列表</legend>
        <div class="layui-field-box layui-form">
            <table class="layui-table admin-table">
                <thead>
                <tr>
                    <th style="width: 30px;"><input type="checkbox" lay-filter="allselector" lay-skin="primary"></th>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>邮箱</th>
                    <th>性别</th>
                    <th>所属院系</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="content">
                </tbody>
            </table>
        </div>
    </fieldset>
    <!-- <div class="admin-table-page">
        <div id="paged" class="page">
        </div>
    </div> -->
</div>

<!--模板-->
<script type="text/html" id="tpl">
    {{# layui.each(d.list, function(index, item){ }}
    <tr>
        <td><input type="checkbox" lay-skin="primary"></td>

        <td>{{ item.user_id }}</td>
        <td>{{ item.user_name }}</td>
        <td>{{ item.user_email}}</td>
        <td>{{ item.user_sex }}</td>
        <td>{{ item.major_id.dpm_id.dpm_name }}</td>

        <td>
            <a href="javascript:;" data-name="{{ item.user_id }}" data-opt="edit"
               class="layui-btn layui-btn-mini">编辑</a>
            <a href="javascript:;" data-name="{{ item.user_id }}" data-opt="reset"
               class="layui-btn layui-btn-mini">重置密码</a>
            <a href="javascript:;" data-user_id="{{ item.user_id }}" data-opt="del"
               class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
        </td>
    </tr>
    {{# }); }}
</script>

<script type="text/javascript" src="${sjc}/layui/layui.js"></script>
<script type="text/javascript" src="${sjc}/layui/layui.all.js"></script>
<script>

    layui.config({
        base: '${sjc}/js/'
    });


    layui.use(['paging', 'form', 'laytpl'], function () {
        var $ = layui.jquery,
            paging = layui.paging(),
            layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
            layer = layui.layer, //获取当前窗口的layer对象
            form = layui.form;
        // alert("form1:"+form);
        var laytpl = layui.laytpl;

        function search() {
            var editorName = $("#editorName").val();
            $.ajax({
                contentType: "application/json; charset=utf-8",
                type: 'post',
                url: '${sjc}/admin/selectEditor', //地址
                data: JSON.stringify({'user_name': editorName}),
                success: function (json) {
                    //layer.msg(json.msg);
                    var obj = json.list;
                    if (json.status == '0') {
                        var date = {
                            list: json.list
                        }
                        $('#content').html('');
                        var gettpl = $('#tpl').html();
                        laytpl(gettpl).render(date, function (html) {
                            $('#content').html(html);
                        });
                        //绑定所有编辑按钮事件
                        $('#content').children('tr').each(function () {
                            var $that = $(this);
                            $that.children('td:last-child').children('a[data-opt=edit]').on('click', function () {

                                //本表单通过ajax加载 --以模板的形式，当然你也可以直接写在页面上读取
                                $.get('updateEditor.jsp?user_id=' + $(this).data('name'), null, function (form) {
                                    addBoxIndex = layer.open({
                                        type: 1,
                                        title: '修改用户信息',
                                        content: form,
                                        btn: ['保存', '取消'],
                                        shade: false,
                                        area: ['40%', '80%'],
                                        zIndex: 1,
                                        maxmin: true,
                                        yes: function (index) {
                                            //触发表单的提交事件
                                            $('form.layui-form').find('button[lay-filter=edit]').click();
                                        },
                                        full: function (elem) {
                                            var win = window.top === window.self ? window : parent.window;
                                            $(win).on('resize', function () {
                                                var $this = $(this);
                                                elem.width($this.width()).height($this.height()).css({
                                                    top: 0,
                                                    left: 0
                                                });
                                                elem.children('div.layui-layer-content').height($this.height() - 95);
                                            });
                                        },
                                        success: function (layero, index) {
                                            //弹出窗口成功后渲染表单
                                            //var form = layui.form;
                                            // alert("layui:"+layui);
                                            //alert("form2:"+form);
                                            //  form.render();

                                            //console.log(layero, index);
                                        },
                                        end: function () {
                                            addBoxIndex = -1;
                                        }
                                    });
                                });

                            });

                            //删除
                            $that.children('td:last-child').children('a[data-opt=del]').on('click', function () {
                                var user_id = $(this).data('user_id');
                                layer.confirm('确定删除?', {icon: 3, title: '提示'}, function (index) {
                                    $.ajax({
                                        contentType: "application/json; charset=utf-8",
                                        type: "POST",
                                        url: '${sjc}/admin/deleteEditor', //地址
                                        data: JSON.stringify({'user_id': user_id}),
                                        success: function (json) {
                                            layer.msg(json.msg);
                                            if (json.status == '0') {
                                                layerTips.msg('删除成功！');
                                                layerTips.close(index);
                                                location.reload(); //刷新
                                                layer.close(index); //如果设定了yes回调，需进行手工关闭
                                            }
                                        },
                                        error: function (res) {
                                            layer.msg(res);
                                        }
                                    });
                                });
                            });

                            //重置密码
                            $that.children('td:last-child').children('a[data-opt=reset]').on('click', function () {
                                //layer.msg($(this).data('id'));
                                var user_id = $(this).data('name');
                                layer.confirm('确定重置?', {icon: 3, title: '提示'}, function (index) {
                                    $.ajax({
                                        contentType: "application/json; charset=utf-8",
                                        type: "POST",
                                        url: '${sjc}/admin/resetEditorPwd', //地址
                                        data: JSON.stringify({'user_id': user_id}),
                                        success: function (json) {
                                            layer.msg(json.msg);
                                            if (json.status == '0') {
                                                //layerTips.msg('重置成功！');
                                                layerTips.close(index);
                                                location.reload(); //刷新
                                                layer.close(index); //如果设定了yes回调，需进行手工关闭
                                            }
                                        },
                                        error: function (res) {
                                            layer.msg(res);
                                        }
                                    });
                                });
                            });


                        });
                    }
                }
            });
        }


        search();

        //搜索search
        $('#search').on('click', function () {
            search();
        });

        var addBoxIndex = -1;
    });
</script>
</body>
</html>
