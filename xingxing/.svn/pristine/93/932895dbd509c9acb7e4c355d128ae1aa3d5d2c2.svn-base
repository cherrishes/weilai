__author__ = 'rdy'

from util.mongodbutil import get_db
from datetime import date
import datetime
from bson import ObjectId


class Handle:
    def get_temperature_gui(self):
        db = get_db()
        """
        #当前数据库 柜温，湿度，环温各插入楼5条模拟数据
        db.ebc_status.save({'type':3,'device_id':'1','value':33,'content':'当前环温','create_date':datetime.utcnow()})
        db.ebc_status.save({'type':3,'device_id':'2','value':32,'content':'当前环温','create_date':datetime.utcnow()})
        db.ebc_status.save({'type':3,'device_id':'3','value':34,'content':'当前环温','create_date':datetime.utcnow()})
        db.ebc_status.save({'type':3,'device_id':'4','value':36,'content':'当前环温','create_date':datetime.utcnow()})
        db.ebc_status.save({'type':3,'device_id':'5','value':30,'content':'当前环温','create_date':datetime.utcnow()})
        """
        try:
            temperature_gui = db.ebc_status.find({'type': 1})
            guiwen = []
            for temp in temperature_gui:
                guiwen.append(temp['value'])

            return guiwen
        except Exception as e:
            print(e)

    def get_humidity_gui(self):
        db = get_db()
        try:
            humidity_gui = db.ebc_status.find({'type': 2})

            humidity = []
            for temp in humidity_gui:
                humidity.append(temp['value'])

            return humidity
        except Exception as e:
            print(e)

    def get_temperature_huan(self):
        db = get_db()
        try:
            temperature_huan = db.ebc_status.find({'type': 3})

            temperature_h = []
            for temp in temperature_huan:
                temperature_h.append(temp['value'])

            return temperature_h
        except Exception as e:
            print(e)

    def get_format_date(self, month, day, hour, minute):
        if month < 10:
            mo = '0' + str(month)
        else:
            mo = str(month)
        if day < 10:
            d = '0' + str(day)
        else:
            d = str(day)
        if hour < 10:
            h = '0' + str(hour)
        else:
            h = str(hour)
        if minute < 10:
            m = '0' + str(minute)
        else:
            m = str(minute)
        return mo + '-' + d + ' ' + h + ':' + m

    def get_device_data(self, dev_id, user_id):
        """
        获取设备数据
        :param dev_id:
        :return:
        """
        db = get_db()
        data = dict()

        device = db.ebc_user_device.find_one({'user_id': user_id, 'device_id': dev_id})
        data['room_name'] = None
        data['alias'] = '无别名'
        if device:
            room_id = device.get('room_id', None)
            if room_id:
                room = self.get_room(room_id)
                if room:
                    data['room_name'] = room.get('name', None)
            data['alias'] = device.get('alias', '无别名')

        temp_gui = []
        temp_huan = []
        humidity = []
        try:
            s = datetime.timedelta(minutes=30)
            now = datetime.datetime.now()
            minute = now.minute
            if minute >= 30:
                minute = 30
            else:
                minute = 0
            today = date.today()
            hour = now.hour
            second = now.second

            newest = str(today) + ' ' + str(hour) + ':' + str(minute) + ':' + str(second)
            max_date = datetime.datetime.strptime(str(newest), '%Y-%m-%d %H:%M:%S')

            for i in range(49):
                trans = self.get_format_date(max_date.month, max_date.day, max_date.hour, max_date.minute)
                min_date = max_date - s
                # 因为数据库保存的时间是utc时间,所以时间需要减8
                statuses = db.ebc_status.find(
                    {'device_id': dev_id, 'create_date': {'$lte': max_date - datetime.timedelta(hours=8),
                                                          '$gt': min_date - datetime.timedelta(hours=8)}}).sort(
                    [('create_date', -1)]).limit(1)
                if statuses.count() > 0:
                    for status in statuses:
                        value = status.get('value', None)
                        if value:
                            temp_gui.append({'date': trans, 'value': value.get('temperature', 'null')})
                            temp_huan.append({'date': trans, 'value': value.get('env_temperature', 'null')})
                            humidity.append({'date': trans, 'value': value.get('humidity', 'null')})
                        else:
                            temp_gui.append({'date': trans, 'value': 'null'})
                            temp_huan.append({'date': trans, 'value': 'null'})
                            humidity.append({'date': trans, 'value': 'null'})
                else:
                    temp_gui.append({'date': trans, 'value': 'null'})
                    temp_huan.append({'date': trans, 'value': 'null'})
                    humidity.append({'date': trans, 'value': 'null'})
                max_date = min_date
            # 反转列表,将时间从小到大排序
            data['gw'] = temp_gui[::-1]
            data['hm'] = humidity[::-1]
            data['hw'] = temp_huan[::-1]
        except Exception as e:
            print(e)

        return data

    def get_room(self, room_id):
        """
        根据room_id获取房间信息
        :param room_id:
        :return:
        """
        db = get_db()
        if isinstance(room_id, ObjectId):
            result = db.ebc_room.find_one({'_id': room_id})
        else:
            result = db.ebc_room.find_one({'_id': ObjectId(room_id)})
        return result

