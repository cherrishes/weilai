__author__ = 'rdy'
from django.conf.urls import patterns, url
urlpatterns = patterns(
    'app.freezer.api.room_dev_list.dev_list.views',
    # 设备详细信息
    url(r'(?i)^device_detail$', 'device_detail'),
    url(r'(?i)^gwcontrol$', 'allrequire'),
    url(r'(?i)^hmcontrol$', 'allrequire'),
    url(r'(?i)^hwcontrol$', 'allrequire'),
    # 获取图表数据
    url(r'(?i)^all_data$', 'all_data'),
    url(r'(?i)^senddata$', 'send_data'),

)
urlpatterns += patterns(
    'app.freezer.api.room_dev_list.room_list.views',
    # 设备列表
    url(r'(?i)^device_list$', 'device_list'),  # 接收参数type=2表示请求异常设备列表 ，其他表示请求所有设备列表
    url(r'(?i)^get_extra_room$', 'get_extra_room'),
    url(r'(?i)^get_extra_device$', 'get_extra_device'),
    # 获取正常、异常设备总数
    url(r'(?i)^get_total$', 'get_total'),
    url(r'(?i)^normal_data$', 'normal_data'),
    url(r'(?i)^error_data$', 'error_data'),
    url(r'(?i)^choose_room$', 'choose_room'),
    url(r'(?i)^update_room_id$', 'update_room_id'),
    url(r'(?i)^get_all_room$', 'get_all_room'),
    # 根据房间id获取设备列表
    url(r'(?i)^get_device_by_id$', 'get_device_by_id'),
    # 测试页面
    url(r'(?i)^test/$', 'update_data'),

)