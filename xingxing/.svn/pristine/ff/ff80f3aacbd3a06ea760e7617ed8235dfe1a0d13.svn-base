from bson import ObjectId
import requests
from util.mongodbutil import get_db

__author__ = 'sunshine'


def test_all_room():
    url = 'http://127.0.0.1:8000/freezer/api/dev/all_room/?token=api_token_123456&q=1'
    resp = requests.post(url=url)
    print(resp.text)

# test_all_room()


def modify_db():
    db = get_db()
    db.ebc_room.update({'_id': {'$lt': ObjectId('5565a90a808df7fd642ec8dc')}}, {'$set': {'user_id': '123456789'}}, multi=True)

# modify_db()


def test_get_extra_device():
    data = {
        'status': 0
    }
    url = 'http://127.0.0.1:8000/freezer/api/dev/get_extra_device/123456789'
    resp = requests.post(url=url, data=data)
    print(resp.text)
# test_get_extra_device()