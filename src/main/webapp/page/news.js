
$(function () {
        //从home.js传过来的参数解析
        var Request = new Object();
        Request = GetRequest();
        var id = Request['id'];
        //查询一条新闻
        select_zixun_id(id);

    huifu(id)


});
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串,如"?p=1"
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
//查询咨询推荐
function zixun(news, major) {
    $("#right_ul").empty();
    $.ajax({
        contentType: "application/json; charset=utf-8",
        type: "post",
        url: "news/selectNews_majorList",
        async: true,
        cache: false,
        data: JSON.stringify(
            {
                "news_id": news, "major_id":{
                    "major_id":major
                }
            }
        ),
        dateType: "json",
        success: function (data) {
            if (data.status == "success") {
                $.each(data.list, function (index, item) {
                    var j =    "<li class='right_li'>"

                        +"<a href='javascript:chaxun_user(" + item.news_id + ")' class='right_ul_li_a'><span>"+(index+1)+" </span>"+item.news_title+"</a>"
                        +"<hr style='width: 90%;color: #000;'>"
                        +"</li>"
                    $("#right_ul").append(j);
                });
            } else {
                alert("error  zixun");
            }
        }, error: function (data) {
            alert("错误!!");
        }
    });
}
    //查询某一专业，且不包括正在浏览的新闻
    function select_zixun_id(id){
        //查询某一专业，且不包括正在浏览的新闻    给news_id，major_id设置全局变量
        var news,major;
        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "post",
            url: "news/selectNews_user",
            async: true,
            cache: false,
            data: JSON.stringify(
                {
                    "news_id": id
                }
            ),
            dateType: "json",
            success: function (data) {
                if (data.status == "success") {
                    $("#news_title").html(data.list.news_title);
                    $("#mojor_name").html(data.list.major_id.major_name);
                    $("#news_date").html(data.list.news_date);
                    $("#news_browse").html(data.list.news_browse);
                    $("#span_name").html(data.list.user_id.user_name);
                    $("#news_image").attr("src", data.list.news_image);
                    var p = data.list.news_content;
                    $("#p1").html(p);

                    news = data.list.news_id;
                    major = data.list.major_id.major_id;

                    zixun(news,major);

                    //查询新闻下面的评论
                    chaxun_Comment_list(id);


                } else {

                }
            }, error: function (data) {
                alert("错误!!!!");
            }
        })
    }
    //查询新闻下面的评论
    function chaxun_Comment_list(news_id) {

        $("#jieda").empty();
        var a,p;
        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "post",
            url: "Comment/selectComment_list",
            async: true,
            cache: false,
            data: JSON.stringify(
                {
                    "news_id":{
                        "news_id":news_id
                    }

                }

            ),
            dateType: "json",
            success: function (data) {
                if (data.status == "success") {
                    $.each(data.list, function (index, item) {
                         var j =    "<li data-id='111' class='jieda-daan'>"
                            +"<a name='item-1111111111'></a>"
                            +"<div class='detail-about detail-about-reply'>"
                            +"<a class='fly-avatar' href=''>"
                            +"<img src="+item.user_id.user_image+" alt=''>"
                            +"</a>"

                            if (item.user_id.state_id.state_id == "") {
                                 a = "<div class='fly-detail-user detail_margin'>"
                                    +"<a href='' class='fly-link'>"
                                    +"<cite>"+item.user_id.user_name+"</cite>"
                                    +"</a>"

                                    +"<span>(楼主)</span>"
                                     +"</div>"
                            }else if(item.user_id.state_id.state_id == 1){
                                a = "<div class='fly-detail-user detail_margin'>"
                                    +"<a href='' class='fly-link'>"
                                    +"<cite>"+item.user_id.user_name+"</cite>"
                                    +"</a>"

                                    +"<span style='color:#5FB878'>(管理员)</span>"
                                    +"</div>"
                            }else if(item.user_id.state_id.state_id == 2){
                                a = "<div class='fly-detail-user detail_margin'>"
                                    +"<a href='' class='fly-link'>"
                                    +"<cite>"+item.user_id.user_name+"</cite>"
                                    +"</a>"

                                    +"<span style='color:#FF9E3F'>（主编）</span>"
                                    +"</div>"
                            }
                        //     <!--
                        //     <span style="color:#5FB878">(管理员)</span>
                        //     <span style="color:#FF9E3F">（社区之光）</span>
                        // <span style="color:#999">（该号已被封）</span>
                        // -->
                        var b = "<div class='detail-hits detail_margin'>"
                            +"<span>"+item.c_datetime+"</span>"
                            +"</div>"
                            +"</div>"
                            +"<div class='detail-body jieda-body photos detail_body_margin'>"
                            +"<p>"+item.c_comment+"</p>"
                        +"</div>"
                        +"<div class='jieda-reply'>"
                            +"<span id='#dianzan' class='jieda-zan' type='zan'>"
                            +"<i  class='iconfont icon-zan' onclick='dianan("+item.c_id+","+item.news_id.news_id+")'></i>"
                            +"<em id='dianzanshu'>"+item.c_dot+"</em>"
                            +"</span>"
                            +"<span type='reply'>"
                            +"<i class='iconfont icon-svgmoban53'>  回复</i>"

                        +"</span>"

                         p = "<div class='jieda-admin'>"
                            +"<span type='edit'>编辑</span>"
                            +"<span type='del' onclick='CommentDelete("+item.c_id+","+item.news_id.news_id+")'>删除</span>"
                            +"</div>"
                            +"</div>"
                            +"</li>"
                        $("#jieda").append(j+a+b+p);
                    });
                }else {
                    <!-- 无数据时 -->
                    var k = "<li class='fly-none'>消灭零回复</li>"
                    $("#jieda").append(k);
                }
            }, error: function (data) {
                alert("错误!! 评论");
            }
        });
    }
    //删除评论
    function CommentDelete(cid,news_id) {
        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "post",
            url: "Comment/deleteComment",
            async: true,
            cache: false,
            data: JSON.stringify(
                {
                    "c_id":cid
                }
            ),
            dateType: "json",
            success: function (data) {
                if (data.status == "success") {
                    chaxun_Comment_list(news_id)
                }
            }, error: function (data) {
                alert("错误!!");
            }
        });
    }
    //点赞
    function dianan(cid,news_id){
        var times = 0;
        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "post",
            url: "Comment/updateComment_dianzan",
            async: true,
            cache: false,
            data: JSON.stringify(
                {
                    "c_id":cid,
                }
            ),
            dateType: "json",
            success: function (data) {
                if (data.status == "success") {
                    if (times != 0) {
                        layer.msg('玩命提示中');
                    }else{
                        times++;
                        chaxun_Comment_list(news_id);
                    }
                }
            }, error: function (data) {
                alert("错误!!");
            }
        });
    }



/*$("#dianzan").one('click',function(){
    var cid =  $(this).next().text();
    alert(cid)

});*/

    //回复评论
    function huifu(news_id){

        layui.use('form', function(){
            var form=layui.form;

            form.on('submit(huifu)', function(data) {

                var L_content = $("#L_content").val();
                alert(L_content)

                var name_id = 1;
                var id = news_id;
                alert(news_id)

                $.ajax({
                    contentType: "application/json; charset=utf-8",
                    type: "post",
                    url: "Comment/insertComment_huifu",
                    async: true,
                    cache: false,
                    data: JSON.stringify(

                        {


                            "c_comment":L_content,
                            "news_id":{
                                "news_id":id
                            },
                            "user_id":{
                                "user_id":name_id
                            }
                        }
                    ),

                    success: function (data) {
                        if (data.status == "success") {

                            chaxun_Comment_list(news_id)
                            $("#L_content").empty();
                        }
                    }, error: function (data) {
                        alert("错误!!添加");
                    }
                });

                 return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            })
        });
    }


