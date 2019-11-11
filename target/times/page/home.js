
/*查询新闻*/
$(function () {
  layui.use(['element', 'layer'], function () {
      var major_name = "";

    var $ = layui.jquery;
        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "post",
            url: "news/selectNews_list",
            async: true,
            cache: false,
            data:JSON.stringify(
                {
                    "major_id":{
                        "major_name":major_name
                    }
                }
            ),
            dateType: "json",
            success: function (data) {
                if (data.status == "success") {
                    $.each(data.list, function (index, item) {


                        var c = "<li>"
                            + "<a href='user/home.html' class='fly-avatar'>"
                            + "<img src="+item.user_id.user_image+" alt='贤心'>"
                            + "</a>"
                            + "<h2>"
                            + "<a class='layui-badge badge'>" + item.major_id.major_name+ "</a>"
                            + "<a href='javascript:chaxun_user(" + item.news_id + ")' class='cilckUser'>" + item.news_title + "</a>"
                            + "</h2>"
                            + "<p class='p_left p_font_size'>"+item.news_remarks+"<span>......</span></p>"
                            + "<div class='fly-list-info  div_info'>"
                            + "<a href='user/home.html' link>"
                            + "<cite>" + item.user_id.user_name + "</cite>"
                            + "</a>"
                            + "<span>" + item.news_date + "</span>"
                            + "<span class='layui-badge fly-badge-accept layui-hide-xs'>标签</span>"
                            + "<span class='fly-list-nums'>"
                            + "<i class='iconfont icon-pinglun1' title='回答'></i> " + item.news_browse + ""
                            + "</span>"
                            + "</div>"
                            + "</li>"
                        $("#top").append(c);
                    });
                } else {
                    alert("error");
                }
            }, error: function (data) {
                alert("错误!!!!");
            }
        });
      //查询热度新闻
      $.ajax({
          type: "post",
          url: "news/selectNews_heat",
          async: true,
          cache: false,
          data: {},
          dateType: "json",
          success: function (data) {
              if (data.status == "success") {
                  $.each(data.list, function (index, item) {
                    var j = "<dd>"+
                      "<a href='javascript:void(0);' onclick='select_home_zixun("+item.news_id+")'>"+item.news_title+"</a>"+
                      "<span><i class='iconfont icon-pinglun1'></i> "+item.news_browse+"</span>"+
                      "</dd>"
                      $("#heat").append(j);
                  });
              } else {
                  alert("error");
              }
          }, error: function (data) {
              alert("错误!!");
          }
      });
    })
});
function chaxun_user(id) {
    var id = id;
    $.ajax({
        contentType: "application/json; charset=utf-8",
        type: "post",
        url: "news/selectNews_user",
        async: true,
        cache: false,
        data:JSON.stringify(
            {
                "news_id":id
            }
        ),
        dateType: "json",
        success: function (data) {
            if (data.status == "success") {

               /* $("#news_title").val(data.list.news_title);
                $("#mojor_name").val(data.list.major_id.major_name);
                $("#news_date").val(data.list.news_date);
                $("#news_browse").val(data.list.news_browse);
                $("#span_name").val(data.list.user_id.span_name);*/

                window.location.href="news.jsp?id="+id;

            } else {
                layer.msg("error");
            }
        }, error: function (data) {
            alert("错误  999");
        }
    })
};
function select_home_zixun(id){
    window.location.href="news.jsp?id="+id;
}
