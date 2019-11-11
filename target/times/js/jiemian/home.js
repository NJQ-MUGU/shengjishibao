$(function(){
    // $(".conent_li").hover(
    //     function(){
    //         $(this).find("ul").show(200);
    //     },function(){
    //         $(this).find("ul").hide(200);
    //     }
    // );
    $(".conent_li").hover(
        function(){
            $(this).find("ul").fadeIn(200);
        },function(){
            $(this).find("ul").fadeOut(200);
        }
    );
})

