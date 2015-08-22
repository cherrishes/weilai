# from IN import AF_INET
from _socket import SOCK_STREAM, AF_INET
import json
from socket import socket

from conf.commonconf import PROTOCOL_HOST, PROTOCOL_PORT


def send(did, cmd, val):
    """
    往协议服务器发送控制命令
    :param did: 设备编号
    :param cmd: 命令
    :param val: 命令值
    :return:
    """
    data = {"msg": {"type": "cmd", "value": did + "|" + cmd + "|" + val, "remarks": ""}}
    data = json.dumps(data)
    host = PROTOCOL_HOST
    port = PROTOCOL_PORT
    client = socket(AF_INET, SOCK_STREAM)
    client.connect((host, port))
    if not data or data == 'exit':
        return "0"
    client.send(data.encode("utf8"))
    client.close()
    res = "1"
    return res


def query(cmd, value):
    """
    往协议服务器发送查询命令
    设备离线：
    {"_status": "OK", "id": "0000", "value": "-1|-1|-1|-1|-1|-1||-1"}
    设备未上传数据：
    {"_status": "OK", "id": "0000", "value": "0|0|0|0|0|0||0"}
    正常的数据：
    {"_status": "OK", "id": "0000", "value": "30|3.2|65|1|1|1|湿度传感器故障|1"}
    :param cmd: 命令
    :param value: 命令值
    :return:服务器返回的json格式数据
    """
    data = {"msg": {"type": str(cmd), "value": str(value), "remarks": ""}}
    data = json.dumps(data)
    host = PROTOCOL_HOST
    port = PROTOCOL_PORT
    bs = 1024
    client = socket(AF_INET, SOCK_STREAM)
    client.connect((host, port))
    if not data or data == 'exit':
        return "0"
    # 先接收再发送
    client.recv(bs)
    client.send(data.encode("utf8"))
    data = client.recv(bs)
    # print(data.strip())
    if not data:
        return "0"
    client.close()
    res = None
    try:
        res = data.decode('utf8')
    except Exception as e:
        print(str(e))
    return res