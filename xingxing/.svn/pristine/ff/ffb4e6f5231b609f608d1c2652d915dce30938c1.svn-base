# _*_coding:utf-8_*_
__author__ = 'Administrator'


def md5(s):
    import hashlib

    if isinstance(s, bytes):
        m = hashlib.md5()
        m.update(s)
        return m.hexdigest()
    else:
        raise Exception("请输入bytes类型")