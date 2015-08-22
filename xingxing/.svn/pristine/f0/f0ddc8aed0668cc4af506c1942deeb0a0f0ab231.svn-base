# _*_coding:utf-8_*_
import requests

__author__ = 'Administrator'


def get_html(url):
    response = requests.get(url)
    content = response.content.decode('utf-8')
    print(content)
    return content


get_html('http://www.weather.com.cn/weather1d/101210101.shtml')
