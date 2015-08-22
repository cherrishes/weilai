api文档
=======

第三方帐号登录接口
-----------------

* 接口地址：http://qingke.device.53iq.com/freezer/api/third_login
* HTTP方式：POST

输入参数
^^^^^^^^
=============    ====
参数              说明
=============    ====
openid            openid/uid
access_token       token值
account_type      帐号类型（0：普通帐号，1：QQ，2：微信，3：新浪微博）
head_url         头像（url地址）
nickname         昵称
=============    ====

输出参数
^^^^^^^^
::

        {
            "_status": "ok",
            "data": {
                'is_need_update': 0,
                'type': '',
                "token": '',
                'expire_in': '',
                'mosquitto_host': 'mosquitto主机地址',
                'mosquitto_port': '主机端口',
                'mosquitto_client_id': 'client_id，客户端唯一标识',
                'mosquitto_sub_user': '订阅者帐号',
                'mosquitto_sub_pwd': '订阅者密码',
                'mosquitto_topic': '订阅主题'

            },
            "errormsg": ""
        }

上报mac地址接口
--------------

* 接口地址：http://qingke.device.53iq.com/freezer/api/submit_mac
* HTTP方式：POST

输入参数
^^^^^^^^
=============    ====
参数              说明
=============    ====
token             登录时返回的TOKEN
openid            openid/uid
account_type      帐号类型（0：普通帐号，1：QQ，2：微信，3：新浪微博）
mac              格式采用16进制串的方式（长度为12字节），不需要0X前缀，如： 1234567890AB
=============    ====
输出参数
^^^^^^^^
::

        {
            "_status": "ok",
            "data": '一直为空',
            "errormsg": ""
        }



获取mac地址列表接口
------------------

* 接口地址：http://qingke.device.53iq.com/freezer/api/get_mac_list
* HTTP方式：POST

输入参数
^^^^^^^^
=============    ====
参数              说明
=============    ====
token             登录时返回的TOKEN
=============    ====

输出参数
^^^^^^^^
::

        {
            "_status": "ok",
            "data": [mac值的列表],
            "errormsg": ""
        }




更新Token时间接口
------------------

* 接口地址：http://qingke.device.53iq.com/freezer/api/update_token
* HTTP方式：GET

输入参数
^^^^^^^^
=============    ====
参数              说明
=============    ====
token            Token值
=============    ====

输出参数
^^^^^^^^
::

        {
            "_status": "ok",
            "data": {
                'token': '',
                'expire_in': ''
            },
            "errormsg": ""
        }



客服电话接口
--------------

* 接口地址：http://qingke.device.53iq.com/freezer/api/service_phone
* HTTP方式：GET/POST

输入参数
^^^^^^^^
========    ====
参数        说明
========    ====
token       登录时返回的TOKEN
========    ====


输出参数
^^^^^^^^
::

    {"_status": "ok", "data": {"phone": "400-620-0033"}, 'errormsg': ''}


关于接口
---------

* 接口地址：http://qingke.device.53iq.com/freezer/api/about
* HTTP方式：GET/POST

输入参数
^^^^^^^^
========    ====
参数        说明
========    ====
token       登录时返回的TOKEN
========    ====

输出参数
^^^^^^^^
::

    {"_status": "ok", "data": {"info": info}, 'errormsg': ''}


设备列表接口
--------------

* 接口地址：http://qingke.device.53iq.com/freezer/api/device/device_list
* HTTP方式：GET

输入参数
^^^^^^^^
========    ====
参数        说明
========    ====
token       登录时返回的TOKEN
type         type=1表示正常设备列表，type=2表示请求异常设备列表
========    ====

输出
^^^^^
HTML页面

分享页面下载接口
--------------

* 接口地址：http://qingke.device.53iq.com/freezer/download
* HTTP方式：GET

输入参数
^^^^^^^^
========    ====
参数        说明
========    ====
无          不需要参数
========    ====

输出
^^^^^
HTML页面

上报device_token接口
--------------

* 接口地址：http://qingke.device.53iq.com/freezer/api/submit_device_token
* HTTP方式：POST

输入参数
^^^^^^^^
===============    ====
参数                  说明
===============    ====
token               用户登录时返回的token
device_token        app从苹果APNS获取到的device_token
===============    ====

输出参数
^^^^^
::

    {"_status": "ok", 'error_msg': ''}    # 上报成功
    {"_status": "error", 'error_msg': error_message}    # 上报失败
    # 说明
    """
    用户每次切换登录帐号时都需要汇报一次device token(为了将device token与当前登录用户绑定)
    推送过来的消息为json格式字符串，示例内容如下：
    """
    {
        "id": "1436268449",
        "type": "push",
        "val": {
            "title": "报警信息",#标题
            "content": "温度传感器故障",# 内容
            "page": 1, #在app底部哪个页面打开（1表示设备中打开，2表示异常设备中打开）
            "url": "http://www.baidu.com" # 点击消息通知后要打开的具体url地址
        }
    }

其他说明
---------

TOKEN异常
^^^^^^^^^

=================   =========
HTTP状态码          原因
=================   =========
401 unauthorized    未传TOKEN
401 invalid token   TOKEN无效
401 token timeout   TOKEN超时，默认TIMEOUT为36000s
=================   =========