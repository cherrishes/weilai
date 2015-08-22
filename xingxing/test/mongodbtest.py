# _*_ coding:utf-8 _*_
"""
Created on 2015-05-22

@author: lujin
"""
import datetime
from bson import ObjectId
from util.mongodbutil import get_db

db = get_db()
doc = {
    '_id': '123',
    'device_token': '124566789558',
    'create_date': datetime.datetime.utcnow()
}
re = db.ebc_device_token.save(doc)
print(re)
# for i in range(100):
#     doc = {
#         'name': '房间'+str(i),
#         'create_date': datetime.datetime.now()
#     }
#     db.ebc_room.insert(doc)
# for i in range(100, 150):
#     doc = {
#         '_id': str(i),
#         'alias': str(i),
#         'err_status': 0,
#         'is_online': True,
#         'mac': 'abc' + str(i),
#         'room_id': ObjectId('5565a90a808df7fd642ec896'),
#         "tag": [{
#           "product_model": "YC-360WDFH" + str(i)
#         }],
#         'type': 1,
#         'create_date': datetime.datetime.now(),
#         'err_date': datetime.datetime.now(),
#     }
#
#     db.ebc_device.insert(doc)

# result = db.ebc_room.find_one({'_id': ObjectId("555549d5f03bde121cd21898")})
# print(result)