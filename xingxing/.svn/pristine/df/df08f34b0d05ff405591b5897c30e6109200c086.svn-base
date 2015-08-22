import uuid

from paho.mqtt import publish
from paho.mqtt.client import MQTTv31

from conf.mqttconf import *


def send(msg, user_list, qos=2, retain=False):
    """
    发布mqtt消息
    :param msg:消息内容，可以是字符串、int、bytearray
    :param user_list: 用户列表数组（不带前缀的），例如:["zhangsan","lilei"]
    :param qos: 消息质量（0：至多一次，1:至少一次，2：只有一次）
    :param retain:设置是否保存消息，为True时当订阅者不在线时发送的消息等上线后会得到通知，否则只发送给在线的设备
    :return:
    """
    auth = {"username": MOSQUITTO_PUB_USER, "password": MOSQUITTO_PUB_PWD}
    client_id = MOSQUITTO_PREFIX + str(uuid.uuid1())
    msgs = []
    for i in user_list:
        print(i)
        msg_obj = dict()
        msg_obj["qos"] = qos
        msg_obj["retain"] = retain
        msg_obj["topic"] = MOSQUITTO_TOPIC_PREFIX + str(i)
        msg_obj["payload"] = msg
        msgs.append(msg_obj)
    if len(msgs) > 0 and msg:
        print(msgs)
        try:
            publish.multiple(msgs, hostname=MOSQUITTO_HOST, port=MOSQUITTO_PORT, client_id=client_id, keepalive=60,
                             will=None, auth=auth, tls=None, protocol=MQTTv31)
            ret = 1
        except Exception as e:
            print(str(e))
            ret = -1
    else:
        ret = -2
    return ret