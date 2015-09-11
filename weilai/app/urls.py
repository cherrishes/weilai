from django.conf.urls import patterns, url

__author__ = 'rdy'
'''
任务编辑系统url配置
'''
task_patterns = patterns(
    'app.views',
    url(r'^$', "task"),
    url(r'^today$', "today"),
    url(r'^list$', "list"),
    url(r'^organize$', "organize"),
    url(r'^week_list$', "week_list"),
    url(r'^test$', "test"),
)