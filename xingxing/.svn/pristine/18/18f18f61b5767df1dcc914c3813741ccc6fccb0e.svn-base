# _*_coding:utf-8_*_
__author__ = 'Administrator'

weather = '晴转多云 多云转阴 多云转小雨 小雨转中雨 中雨转大雨 大雨转暴雨 晴转雨夹雪 阴转多云'


def aqimapping(aqi):
    """
    空气质量指数aqi映射
    :param aqi:aqi数量
    :return:返回aqi的等级
    """
    try:
        aqi = int(aqi)
    except ValueError:
        aqi = -1

    if aqi >= 0:
        if aqi <= 50:
            return '优'
        elif aqi <= 100:
            return '良'
        elif aqi <= 150:
            return '轻度'
        elif aqi <= 200:
            return '中度'
        elif aqi <= 300:
            return '重度'
        elif aqi > 300:
            return '严重'
    else:
        return 'error'


def weathermapping(w):
    """
    映射天气关键字
    :param w:
    :return:
    """
    if not w:
        return None
    if '多云' in w:
        return 'duoyun.png'
    elif '晴' in w:
        return 'qing.png'
    elif '阴' in w:
        return 'yin.png'
    elif '小雨' in w:
        return 'xiaoyu.png'
    elif '中雨' in w:
        return 'zhongyu.png'
    elif '大雨' in w:
        return 'dayu.png'
    elif '暴雨' in w:
        return 'baoyu.png'
    elif '大暴雨' in w:
        return 'dabaoyu.png'
    elif '雷阵雨' in w:
        return 'leizhenyu.png'
    elif '阵雨' in w:
        return 'zhenyu.png'
    elif '雾' in w:
        return 'wu.png'
    elif '冻雨' in w:
        return 'dongyu.png'
    elif '霾' in w:
        return 'mai.png'
    elif '浮尘' in w:
        return 'fuchen.png'
    elif '扬沙' in w:
        return 'yangsha.png'
    elif '沙尘暴' in w:
        return 'shachenbao.png'
    elif '小雪' in w:
        return 'xiaoxue.png'
    elif '中雪' in w:
        return 'zhongxue.png'
    elif '大雪' in w:
        return 'daxue.png'
    elif '雨夹雪' in w:
        return 'yujiaxue.png'
    elif '阵雪' in w:
        return 'zhenxue.png'
    elif '暴雪' in w:
        return 'baoxue.png'


print(weathermapping(''))