# _*_ coding:utf-8 _*_
"""
Created on 2015-05-22

@author: lujin
"""
from django import template

register = template.Library()


def trans_underline(obj, key):
    try:
        return obj[key]
    except:
        return ""

register.filter(trans_underline)
