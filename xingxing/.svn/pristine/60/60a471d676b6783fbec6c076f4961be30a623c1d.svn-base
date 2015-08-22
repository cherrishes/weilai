# _*_coding:utf-8_*_
import re

from django.http import HttpResponseRedirect, HttpResponse

from common.cache_helper import get_mc
from conf.memcachedconf import TOKEN_PREFIX
from conf.sessionconf import SESSION_LOGIN


__author__ = 'Administrator'


def login_required(func):
    """
    登录装饰器，用于判断是否登录
    :param func:
    :return:
    """

    def wrap(request, **kwargs):
        ilog = SESSION_LOGIN in request.session
        if ilog:
            return func(request, **kwargs)
        else:
            # 登录成功后重定向到请求的URI
            rori = request.META.get('REQUEST_URI', '/freezer/')
            return HttpResponseRedirect('/freezer/login?uri=' + rori)

    return wrap


def token_required(func):
    """
    api token值判断
    :param func:
    :return:
    """

    def wrap(request, **kwargs):
        token = request.REQUEST.get("token", None)
        response = HttpResponse()
        if token:
            # 检查token值是否过期
            if re.match("^" + TOKEN_PREFIX + "[0-9\-a-zA-Z]+$", token):
                mc = get_mc()
                val = mc.get(str(token))
                if val:
                    # 对网页进行处理（后期要根据token值进行权限控制）
                    # request.REQUEST["username"] = val
                    return func(request, val, **kwargs)
                    # return func(request, **kwargs)
                else:
                    response.status_code = 401
                    response.reason_phrase = "token timeout"
            else:
                response.status_code = 401
                response.reason_phrase = "invalid token"
        else:
            # 说明没有传递token值过来
            response.status_code = 401
            response.reason_phrase = "unauthorized"
        return response

    return wrap