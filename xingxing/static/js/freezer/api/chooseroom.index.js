/**
 * 从url中获取参数
 * @return {string}
 */
function GetUrlValueByParas(url, paras) {
    var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
    var paraObj = {};
    var i, j;
    for (i = 0; j = paraString[i]; i++) {
        paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
    }
    var returnValue = paraObj[paras.toLowerCase()];
    if (typeof (returnValue) == "undefined") {
        return "";
    } else {
        return returnValue;
    }
}
// 从当前url获取token
var href = window.location.href;
var token = GetUrlValueByParas(href, 'token');

try {
    var save = function () {
        //房间id

        var na = $(".ui-tag-selected").parent("li").attr("id");
        var el;
        try {

            $.ajax({
                type: "POST",
                url: "/freezer/api/device/update_room_id",
                data: {flag: na, dev_id: devid, 'token': token},
                dataType: "json",
                beforeSend: function () {
                    el = Zepto.loading({
                        content: '保存中...'
                    });
                },
                success: function (data) {
                },
                error: function (a) {
                },
                complete: function () {
                    //关闭并刷新之前的页面
                    el.loading("hide");
                    try{
                        android.closeWindow(true);
                    }
                    catch (e){

                        window.location.href = '/freezer/api/device/device_detail?token='+token+'&devid='+devid
                    }

                }
            });
        } catch (e) {
            console.log(e);
        }
    };
    freezer.setRightButton("保存", save);
} catch (e) {
    console.log(e);
    $("#ui-saveBtn").show();
    $("#ui-saveBtn").bind('tap',save)
}
var elGetALl;
$.ajax({
    type: "GET",
    url: "/freezer/api/device/get_all_room",
    data: {flag: "tl", 'skip': 0, 'token': token},
    dataType: "json",
    beforeSend: function () {
        elGetALl = Zepto.loading({
            content: '加载中...'
        });
    },
    success: function (data) {
        try {
            $.each(data["res"], function (index, item) {
                var temp1 = "<li class='ui-border-t' id='" + item.id + "'><h4 >" + item.name + "</h4></li>";
                if (item.id == roomid) {
                    temp1 = "<li class='ui-border-t' id='" + item.id + "'><h4 >" + item.name + "</h4><div class='ui-tag-selected'></div></li>";
                }
                $("#ui-border-b1").append(temp1);
            });
            Zepto(".ui-border-t").on("tap",
                function () {
                    $(".ui-tag-selected").remove();
                    $(this).append("<div class='ui-tag-selected'></div>")
                });
        }
        catch (e) {
            console.log(e);
        }
    },
    complete: function () {
        elGetALl.loading("hide");
    }
});
//滚动到顶部
Zepto('.ui-scroll-top').on('tap', function () {
    document.body.scrollTop = 0;
});

//获取滚动条高度
function getScrollTop() {
    var scrollTop = 0;
    if (document.documentElement && document.documentElement.scrollTop) {
        scrollTop = document.documentElement.scrollTop;
    }
    else if (document.body) {
        scrollTop = document.body.scrollTop;
    }
    return scrollTop;
}

//加载房间列表
function loadRoom() {
    $('.ui-loading-wrap').remove();
    $('#ui-border-b1').append('<div class="ui-loading-wrap"><p>加载中</p><i class="ui-loading"></i></div>');
    loading = true;
    var skip = $('#ui-border-b1').children('li').length;
    $.post('/freezer/api/device/get_all_room', {'skip': skip, 'limit': 10, 'token': token}, function (data) {
        try {
            var html = "";
            if (data['res'].length == 0) {
                html = '<div class="ui-loading-wrap ui-border-t"><p>没有更多了...</p></i></div>';
            } else {
                $.each(data["res"], function (index, item) {
                    html += "<li class='ui-border-t' id='" + item.id + "'><h4>" + item.name + "</h4></li>";
                });
            }
            $('.ui-loading-wrap').remove();
            $("#ui-border-b1").append(html);
            Zepto(".ui-border-t").on("tap", function () {
                $(".ui-tag-selected").remove();
                $(this).append("<div class='ui-tag-selected'></div>")
            });
        }
        catch (e) {
            alert(e);
        }
        loading = false;
    }, 'json');
}


//判断是否滚动到底部
var loading = false;
Zepto(document).scroll(function () {
    var top = getScrollTop();
    var doc = $(document).height();
    var win = $(window).height();
    if (top > win / 2) {
        $('.ui-scroll-top').show();
    } else {
        $('.ui-scroll-top').css('display', 'none');
    }
    if (!loading && doc - win > 0) {
        if (top >= doc - win) {
            loadRoom();
            console.log(top);
        }

    }
});