进度规划与分工
========


进度规划：2015.08-25~
------------------------------

api
^^^^^^^^^^^

接口必须得能够处理重复调用的情况

#. 第三方账号登录api
#. 更新token的api
#. 根据坐标计算附近的设备的api（接口必须得能够处理重复调用的情况）
#. app上的“关于”api
#. 消息推送接口(基于mqtt与终端联调)


api(暂时不做)
^^^^^^^^^^^^^^

#. 内部登录注册api
#. 短信校验api（发送短信，返回校验码），注意每个token的时间间隔判断（30s之后才能再发）


app需要提供的jsapi
^^^^^^^^^^^^^^^^^^

#. 调起扫一扫功能，用于扫描设备上的二维码
#. 利用支付宝sdk，调起支付界面

需要与android app端对接的
^^^^^^^^^^^^^^^^^^^^^^^^^

#. 基于mqtt的消息推送（wmqtt.jar）
#. 支付宝sdk是否需要回调地址处理？





任务分工
--------

