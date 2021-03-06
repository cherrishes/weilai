/**
 * Created by tsengdavid on 6/1/15.
 */
//全局配置对象
var dataconf = {
    // 更新房间名称
    update_room: "/freezer/update_room/",
    // 获取所有数据
    all_data: "/freezer/api/device/all_data",
    // 修改设备编号
    update_device_alias: "/freezer/update_device_alias/",
    //设备编号
    "deviceId": devid,
    //报警状态(0:取消报警，1：继续报警，2：工作正常)
    "alertStatus": buzzing_flag_init,
    //箱内灯状态
    "lightStatus": light_flag,
    last_notify: ""
};

Zepto(function () {

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

    /**
     * 调用安卓的接口显示消息弹框
     * @param m
     */
    function msg(m) {
        try {
            android.message(m);
        } catch (e) {
            console.log(e);
            alert(m);
        }
    }

    Zepto('#btnDlgSubmit').tap(function () {
        var room_name = Zepto('#txtRoomName').val();
        if (room_name.length == 0 || room_name.indexOf(' ') != -1) {
            msg('房间名不能为空！');
        }
        else if (room_name.TextFilter() != room_name) {
            msg('房间名不能包含特殊字符！');
        }
        else {
            $.post('{% url "add_room" %}', {'room_name': room_name}, function (response) {
                if (response == '1') {
                    msg('添加成功！');
                    var temp = "<a class='list-group-item aroom' id='" + room_name + "'>" + room_name + "(<span>0</span>)</a>";
                    $("#allroom-ul").append(temp);
                    Zepto(".aroom").on("singleTap", function () {
                        $("#room-Num").text($(this).text());
                        $("#allroom-ul").toggle();
                        $(".ui-border-t").show();
                    });
                    Zepto("#allroom-ul a").on("longTap", function () {
                        var r_name = $(this).text().split("(")[0];
                        Zepto("#del-room").text(r_name);
                        Zepto(".ui-dialog-delete").dialog("show")
                    });
                } else {
                    msg('添加失败！');
                }
            });
            Zepto('#txtRoomName').val('');
        }
    });
    String.prototype.TextFilter = function () {
        //[]内输入你要过滤的字符，这里是我的
        var pattern = new RegExp("[`~%!@#^=''?~！@#￥……&——‘”“'？*()（），,。.、]");
        var rs = "";
        for (var i = 0; i < this.length; i++) {
            rs += this.substr(i, 1).replace(pattern, '');
        }
        return rs;
    };

    // 设置图表数据，使没有数据的时间段用靠近他的下一个时刻的数据，
    // 最后一个时刻如果没有数据则用最靠近的前一个时刻的数据
    var set_chart_data = function (data) {
        var last = 0;
        var len = data.length;
        var temp = 0;
        for (var i = 0; i < len; i++) {
            if (data[i] != null) {
                temp = data[i];
                for (var j = last; j < i; j++) {
                    data[j] = temp;
                }
                last = i + 1;
            }
        }
        if (data[len - 1] == null) {
            for (i = last; i < len; i++) {
                data[i] = temp;
            }
        }
    };


    var global_data_hw = [];
    var global_data_gw = [];
    var global_data_hm = [];
    $(function () {
        //如果设备离线或者数据未上传时弹窗提示用户
        if ($("#modelText").val() == "设备离线") {
            setTimeout(function () {
                Zepto.tips({
                    content: '设备离线',
                    stayTime: 2000,
                    type: "warn"
                })
            }, 1000);
        }

        //修改设备编号(即修改别名)
        $("#imgEditDeviceId").bind("tap", function () {
            var dev_alias = prompt("修改编号(1~14位数字)", $("#spanDeviceAlias").children('a').text());
            var flag = false;
            while (dev_alias != null && !flag) {
                flag = update_device_id(dev_alias);
                if (!flag) {
                    dev_alias = prompt("修改编号(1~14位数字)", dev_alias);
                } else {
                    break;
                }
            }
        });
        //修改设备编号
        function update_device_id(dev_alias) {
            if (!/^\d{1,14}$/gi.test(dev_alias)) {
                msg('设备编号必须为1~14位数字！');
                return false;
            }
            else {
                // 从当前url获取token
                var href = window.location.href;
                var token = GetUrlValueByParas(href, 'token');
                $.ajax({
                    type: "POST",
                    url: dataconf.update_device_alias,
                    data: {'dev_alias': dev_alias, 'dev_id': dataconf.deviceId, 'token': token},
                    dataType: "json",
                    success: function (data) {
                        if (data['status'] == 1) {
                            $("#spanDeviceAlias").children('a').text(dev_alias);
                            msg(data['msg']);
                        } else {
                            msg(data['msg']);
                        }
                    }
                });
                return true;
            }
        }

        $("#freezer-humidity").css('width', $(window).width() + "px");
        $('#temperature-huan').css('width', $(window).width() + "px");
        $(document).ready(function () {
            $(".header").remove();
            $(".footer").remove();
            $("#currentDate").html("柜温<span style=\"font-size:16px;\">℃ " + show() + "</span>");
            $("#currentDate2").html("柜湿<span style=\"font-size:16px;\">% " + show() + "</span>");
            $("#currentDate3").html("环温<span style=\"font-size:16px;\">℃ " + show() + "</span>");
            $(".table-g").hide();
            $(".table-shi").hide();
            $(".table-h").hide();
            $(".ui-border-tb").hide();
            Highcharts.setOptions({
                global: {
                    useUTC: false
                }
            });

            $('#temperature-gui').highcharts({
                chart: {
                    type: 'line'
                },
                title: {
                    text: '',
                    x: -20
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    minorTickInterval: 1,
                    categories: []
                },
                yAxis: {
                    max: 40,
                    min: -40,
                    minorTickInterval: 5,
                    minorTickLength: 10,

                    title: {
                        text: null
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: '°C'
                },

                series: [{
                    name: '柜温',
                    data: []
                }]
            });
            $("#temperature-gui svg").children(":last").remove();
            $("svg path:first").remove();
            var el;
            $.ajax({
                type: "POST",
                url: dataconf.all_data + location.search,
                data: {flag: "gw"},
                dataType: "json",
                beforeSend: function () {
                    el = Zepto.loading({
                        content: '加载中...'
                    });
                },
                success: function (data) {
                    // 设置房间名称
                    var roomName = data['room_name'];
                    if (roomName != null && roomName.length > 3) {
                        roomName = roomName.substr(0, 3) + "...";
                    } else if (roomName == null) {
                        roomName = '未分配';
                        $("#edit-img").hide();
                    }
                    $("#room-sel").text(roomName);
                    $("#room-sel").attr("data-name", data['room_name']);

                    // 设置别名
                    $("#spanDeviceAlias a").text(data['alias']);

                    try {
                        var gw = '';
                        var hm = "";
                        var hw = "";
                        for (var j = 0; j < data['hm'].length; j++) {
                            //柜温
                            var gw_value = data['gw'][j]['value'];
                            if (gw_value == 'null') {
                                gw += ("<tr><td>" + data['gw'][j]['date'] + "</td><td></td></tr>");
                                global_data_gw.push(null);
                            } else {
                                gw += ("<tr><td>" + data['gw'][j]['date'] + "</td><td>" + gw_value + "°C</td></tr>");
                                global_data_gw.push(parseFloat(gw_value));
                            }

                            //湿度
                            var hm_value = data['hm'][j]['value'];
                            if (hm_value == 'null') {
                                hm += ("<tr><td>" + data['hm'][j]['date'] + "</td><td></td></tr>");
                                global_data_hm.push(null);
                            } else {
                                hm += ("<tr><td>" + data['hm'][j]['date'] + "</td><td>" + hm_value + "%</td></tr>");
                                global_data_hm.push(parseFloat(hm_value));
                            }

                            //环温
                            var hw_value = data['hw'][j]['value'];
                            if (hw_value == 'null') {
                                hw += ("<tr><td>" + data['hw'][j]['date'] + "</td><td></td></tr>");
                                global_data_hw.push(null);
                            } else {
                                hw += ("<tr><td>" + data['hw'][j]['date'] + "</td><td>" + hw_value + "°C</td></tr>");
                                global_data_hw.push(parseFloat(hw_value));
                            }
                        }
                        // 设置表格数据
                        $("#tbody-guiwen").append(gw);
                        $("#tbody-huanwen").append(hw);
                        $("#tbody-humidity").append(hm);

                        set_chart_data(global_data_gw);
                        set_chart_data(global_data_hm);
                        set_chart_data(global_data_hw);

                        var chart2 = $('#temperature-gui').highcharts();
                        chart2.series[0].setData(global_data_gw);
                        el.loading("hide");
                    } catch (e) {
                        el.loading("hide");
                    }
                    $("#warnBtn").show();
                    $(".ui-switch").show();
                },
                error: function () {
                    Zepto.tips({
                        content: '系统错误',
                        stayTime: 2000,
                        type: "warn"
                    })
                },
                complete: function () {
                    el.loading("hide");
                }
            });

            $('#temperature-huan').highcharts({
                chart: {
                    type: 'line'
                },
                title: {
                    text: '',
                    x: -20
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    minorTickInterval: 1,
                    categories: []
                },
                yAxis: {
                    max: 50,
                    min: -20,
                    minorTickInterval: 5,
                    minorTickLength: 10,
                    title: {
                        text: null
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: '°C'
                },

                series: [{
                    name: '环温',
                    data: []
                }]
            });
            $("#temperature-huan svg path:first").remove();
            $("#temperature-huan svg").children(":last").remove();

            $('#freezer-humidity').highcharts({
                chart: {
                    type: 'line'
                },
                title: {
                    text: '',
                    x: -20
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    categories: []
                },
                yAxis: {
                    max: 100,
                    min: 0,
                    minorTickInterval: 5,
                    minorTickLength: 10,
                    title: {
                        text: null
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: '%'
                },

                series: [{
                    name: '湿度',
                    data: []
                }]
            });
            $("#freezer-humidity svg path:first").remove();
            $("#freezer-humidity svg").children(":last").remove();

            $(".guiwen-listshow").bind("tap", function () {
                if ($(".guiwen-listshow").attr('src') == list_nomal_src) {
                    $(".guiwen-listshow").attr('src', list_press_src);
                    $(".guiwen-tableshow").attr('src', table_nomal_src);
                    $("#temperature-gui").show();
                    $(".table-g").hide();
                }
            });

            $(".guiwen-tableshow").bind("tap", function () {
                if ($(".guiwen-tableshow").attr('src') == table_nomal_src) {
                    $(".guiwen-tableshow").attr('src', table_press_src);
                    $(".guiwen-listshow").attr('src', list_nomal_src);
                    $(".table-g").show();
                    $("#temperature-gui").hide();
                }
            });

            $(".humidity-listshow").bind("tap", function () {
                if ($(".humidity-listshow").attr('src') == list_nomal_src) {
                    $(".humidity-listshow").attr('src', list_press_src);
                    $(".humidity-tableshow").attr('src', table_nomal_src);
                    $("#freezer-humidity").show();
                    $(".table-shi").hide();
                }
            });

            $(".humidity-tableshow").bind("tap", function () {
                if ($(".humidity-tableshow").attr('src') == table_nomal_src) {
                    $(".humidity-tableshow").attr('src', table_press_src);
                    $(".humidity-listshow").attr('src', list_nomal_src);
                    $(".table-shi").show();
                    $("#freezer-humidity").hide();
                }
            });

            $(".huanwen-listshow").bind("tap", function () {
                if ($(".huanwen-listshow").attr('src') == list_nomal_src) {
                    $(".huanwen-listshow").attr('src', list_press_src);
                    $(".huanwen-tableshow").attr('src', table_nomal_src);
                    $("#temperature-huan").show();
                    $(".table-h").hide();
                }
            });
            $(".huanwen-tableshow").bind("tap", function () {
                if ($(".huanwen-tableshow").attr('src') == table_nomal_src) {
                    $(".huanwen-tableshow").attr('src', table_press_src);
                    $(".huanwen-listshow").attr('src', list_nomal_src);
                    $(".table-h").show();
                    $("#temperature-huan").hide();
                }
            });
        });
        //调用安卓的接口显示消息弹框
        function msg(m) {
            try {
                android.message(m);
            } catch (e) {
                console.log(e);
                alert(m);
            }
        }

        function selectRoom(url) {
            try {
                android.openNewUrlWindow(url);
            }
            catch (e) {
               // alert("请更新app后再试！");
                location.href = url;
                console.log(e);
            }
        }

        $("#room-sel").on("tap", function () {
            // 从当前url获取token
            var href = window.location.href;
            var token = GetUrlValueByParas(href, 'token');
            //改为调用终端接口来打开链接
            var url = location.origin + "/freezer/api/device/choose_room?devid=" + dataconf.deviceId + "&token=" + token;
            selectRoom(url);
        });

        /**
         * 箱内灯控制
         */
        var control_light = function () {
            $.ajax({
                type: "POST",
                url: "/freezer/api/device/senddata",
                data: {type: "light", status: dataconf.lightStatus, "devid": dataconf.deviceId},
                success: function (data) {
                    if (data == 1) {
                        Zepto.tips({
                            content: '操作成功',
                            stayTime: 1000,
                            type: "success"
                        })
                    } else {
                        Zepto.tips({
                            content: '操作失败',
                            stayTime: 1000,
                            type: "warn"
                        })
                    }
                }
            });
        };
    var bodyTouch = util.toucher($('.ui-light-control')[0]);
        // 左划事件
        bodyTouch.on('swipeLeft',function(){

            var src = $("#light-check").attr('src');
            if (src == light_open) {
                $("#light-check").attr('src', light_close);
                dataconf.lightStatus = 0;
                control_light();
            }
        });
        // 右划事件
        bodyTouch.on('swipeRight',function(){
            var src = $("#light-check").attr('src');
            if (src == light_close) {
                $("#light-check").attr('src', light_open);
                dataconf.lightStatus = 1;
                control_light();
            }
        });
        /*
        Zepto('.ui-switch').on('swipeLeft', function () {
            var src = $("#light-check").attr('src');
            if (src == light_open) {
                $("#light-check").attr('src', light_close);
                dataconf.lightStatus = 0;
                control_light();
            }
        });

        // 右划事件
        Zepto('.ui-switch').on('swipeRight', function () {
            var src = $("#light-check").attr('src');
            if (src == light_close) {
                $("#light-check").attr('src', light_open);
                dataconf.lightStatus = 1;
                control_light();
            }
        });*/

        // 箱内灯控制
        $("#light-check").bind("tap", function () {
            var src = $("#light-check").attr('src');
            if (src == light_open) {
                $("#light-check").attr('src', light_close);
                dataconf.lightStatus = 0;
            } else {
                $("#light-check").attr('src', light_open);
                dataconf.lightStatus = 1;
            }
            control_light();
        });
        //初始化灯当前状态
        if (dataconf.lightStatus == 1) {
            $("#light-check").attr('src', light_open);

        }
        else if (dataconf.lightStatus == 0) {
            $("#light-check").attr('src', light_close);

        }
        //初始化报警样式状态
        if (dataconf.alertStatus == 1) {
            $("#warnBtn").removeClass("btn-success").addClass(
                "btn-warning").text("继续报警");
        } else if (dataconf.alertStatus == 0) {
            $("#warnBtn").removeClass("btn-warning").addClass(
                "btn-success").text("取消报警");
        }
        else if (dataconf.alertStatus == 2) {
            $("#warnBtn").removeClass("btn-warning").addClass(
                "btn-success").text("工作正常");
        }
        $("#warnBtn").bind(
            "tap",
            function () {
                //如果是“工作正常”的话，就不让它切换了
                if (dataconf.alertStatus == 2) {
                    return false;
                }
                //当前如果是继续报警的话，点击后肯定就是取消报警了
                if (dataconf.alertStatus == 1) {
                    $(this).removeClass("btn-warning").addClass(
                        "btn-success").text("取消报警");
                    dataconf.alertStatus = 0;
                }
                else {
                    $(this).removeClass("btn-success").addClass(
                        "btn-warning").text("继续报警");
                    dataconf.alertStatus = 1;
                }
                $.ajax({
                    type: "POST",
                    url: "/freezer/api/device/senddata",
                    data: {type: "buz", 'status': dataconf.alertStatus, "devid": dataconf.deviceId},
                    dataType: "json",
                    success: function () {
                        Zepto.tips({
                            content: '操作成功',
                            stayTime: 1000,
                            type: "success"
                        })
                    },
                    error: function () {
                        Zepto.tips({
                            content: '操作失败',
                            stayTime: 1000,
                            type: "warn"
                        })
                    }
                });
            });

        $("svg text:last").remove();
        $("svg path:first").remove();

        //修改房间名称
        Zepto("#edit-img").tap(function () {
            var prompRoomName = prompt('修改房间', $("#room-sel").attr("data-name"));
            var flag = false;
            while (prompRoomName != null && !flag) {
                flag = update_room_name(prompRoomName);
                if (flag == false) {
                    prompRoomName = prompt('修改房间', prompRoomName);
                }
                else {
                    msg('修改成功');
                    break;
                }
            }
        });
        function update_room_name(room_name) {
            if (room_name.length == 0 || room_name.indexOf(' ') != -1) {
                msg('房间名不能为空！');
                return false;
            }
            else if (room_name.TextFilter() != room_name) {
                msg('房间名不能包含特殊字符！');
                return false;
            }
            else if (room_name.length > 20) {
                msg('房间名长度1～20字！');
                return false;
            }
            else {
                // 从当前url获取token
                var href = window.location.href;
                var token = GetUrlValueByParas(href, 'token');
                $.ajax({
                    type: "POST",
                    url: dataconf.update_room,
                    data: {'room_name': room_name, 'dev_id': dataconf.deviceId, 'token': token},
                    dataType: "json",
                    success: function (data) {
                        if (data['status'] == 1) {
                            msg(data['msg']);
                            // 判断名称是否过长，过长则截取一部分
                            var roomNamePre = room_name;
                            if (room_name != null && room_name.length > 4) {
                                room_name = room_name.substr(0, 4) + "...";
                            }
                            $("#room-sel").text(room_name);
                            $("#room-sel").attr("data-name", roomNamePre);
                            Zepto('#txtRoomName').val('');
                        } else {
                            msg(data['msg']);
                        }
                    }
                });
                return true;
            }
        }
    });
    try {

        /*----------------------------------------------Comet 整合 Begin-------------------------------------*/
        var freezerid = dataconf.deviceId;
        Orbited.settings.hostname = location.host;
        // comet封装
        function comet() {
            var stomp = new STOMPClient();
            stomp.onconnectedframe = function () {
                var id = freezerid;
                if (!/^\s*$/gi.test(id)) {
                    stomp.subscribe("/" + id);
                }
            };
            stomp.onmessageframe = function (frame) {
                var data = $.parseJSON(frame.body);
                try {
                    current_show(data);
                    console.log(data);
                } catch (e) {
                }
            };
            stomp.connect("localhost", 61613);
        }

        /*----------------------------------------------Comet 整合 End--------------------------------------*/
        comet();
    } catch (e) {
    }

    var tab = new fz.Scroll('.ui-tab', {
        role: 'tab'
    });

    tab.currentPage = 0;
    $(tab.nav.children[0]).removeClass('current');
    $(tab.nav.children[tab.currentPage]).addClass('current');
    tab.on('beforeScrollStart', function (fromIndex, toIndex) {
        if ((fromIndex == 1 && toIndex == 2) || (fromIndex == 0 && toIndex == 2)) {
            try {
                var el = Zepto.loading({
                    content: '加载中...'
                });
                var chart3 = $('#temperature-huan').highcharts();
                chart3.series[0].setData(global_data_hw);
                el.loading("hide");
            }
            catch (e) {

            }
        }

        else if ((fromIndex == 0 && toIndex == 1) || (fromIndex == 2 && toIndex == 1)) {
            try {
                var el = Zepto.loading({
                    content: '加载中...'
                });
                var chart = $('#freezer-humidity').highcharts();
                chart.series[0].setData(global_data_hm);
                el.loading("hide");
            }
            catch (e) {

            }
        }
        console.log(fromIndex, toIndex)
    });

    tab.on('scrollEnd', function () {
        console.log('end')
    });

    //推送过来的消息处理
    function current_show(data) {
        var current_data = data['msg']['value'];
        var temp = current_data.split("|");
        var gw = temp[1];//柜温
        var hw = temp[0];//环温
        var hm = temp[2];//柜湿
        var light = temp[3];//灯箱灯
        var buzzing = temp[5];//蜂鸣器
        var warnText = temp[6];//错误信息
        var dev_model = temp[7];//药柜工作模式


        $("#temperature").text(gw + "°C");
        $("#htemp").text(hw + "°C");
        $("#humidity").text(hm + "%");
        $("#warnText").val(warnText);
        if (dev_model == "0") {
            $("#modelText").val("阴凉模式");
        }
        else if (dev_model == "1") {
            $("#modelText").val("冷藏模式");
        }
        //没有报警信息时显示“工作正常”
        if (/^\s*$/gi.test(warnText)) {
            dataconf.alertStatus = 2;
            $("#warnBtn").removeClass("btn-warning").addClass(
                "btn-success").text("工作正常");
        } else {
            if (buzzing == "0") {
                dataconf.alertStatus = 0;
                $("#warnBtn").removeClass("btn-warning").addClass(
                    "btn-success").text("取消报警");
            }
            else if (buzzing == "1") {
                dataconf.alertStatus = 1;
                $("#warnBtn").removeClass("btn-success").addClass(
                    "btn-warning").text("继续报警")
            }
        }

        if (light == "1") {
            $("#light-check").attr('src', light_open);
            dataconf.lightStatus = 1;
        }
        else if (light == "0") {
            $("#light-check").attr('src', light_close);
            dataconf.lightStatus = 0;
        }

    }

    //获取年月日
    function show() {
        var my_date = new Date();
        var str = (my_date.getMonth() + 1) + "月";
        str += my_date.getDate() + "日";
        return str;
    }
});