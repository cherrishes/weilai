# _*_ coding:utf-8 _*_
import random

__author__ = 'lujin'


def rc4(data, key):
    """
    rc4加密解密算法
    :param data:
    :param key:
    :return:
    """
    x = 0
    box = [x for x in range(256)]
    for i in range(256):
        x = (x + box[i] + ord(key[i % len(key)])) % 256
        box[i], box[x] = box[x], box[i]
    x = 0
    y = 0
    out = []
    for char in data:
        x = (x + 1) % 256
        y = (y + box[x]) % 256
        box[x], box[y] = box[y], box[x]
        out.append(chr(ord(char) ^ box[(box[x] + box[y]) % 256]))

    return ''.join(out)


def rc4_key():
    """
    随机生成rc4密钥
    :return:
    """
    # guid = uuid.uuid1()
    # return str(guid)
    # print(rc4("", '123'))
    key_array = "0123456789abcdefghijklmnopqistuvwxyzABCDEFGHIJKLMNOPQISTUVWXYZ"
    key_result = ""
    for i in range(0, 5):
        a = random.randint(0, 61)
        key_result += key_array[a]
    return key_result