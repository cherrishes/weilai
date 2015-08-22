# _*_coding:utf-8_*_
import pymongo

from conf.mongodbconf import MONGO_ADDR, MONGO_PWD, MONGO_USER, MONGO_PORT, MONGO_SMARTSYS


__author__ = 'Administrator'


def get_conn():
    conn = pymongo.Connection(MONGO_ADDR, MONGO_PORT)
    return conn


def get_db(db=MONGO_SMARTSYS):
    conn = get_conn()
    conn.admin.authenticate(MONGO_USER, MONGO_PWD)
    database = conn[db]
    return database


