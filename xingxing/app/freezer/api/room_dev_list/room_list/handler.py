__author__ = 'rdy'
from bson import ObjectId

from util.mongodbutil import get_db


class Handle:
    def get_total_dev(self, user_id):
        """
        获取统计数量
        :return:
        """
        db = get_db()
        try:
            normal = 0
            error = 0
            devices = db.ebc_user_device.find({'user_id': user_id})

            for device in devices:
                dev_id = device.get('device_id', None)
                if dev_id:
                    result = db.ebc_device.find_one({'_id': dev_id})
                    # 如果设备的err_status是 0 并且is_online为 True，则为正常设备,其他均为异常设备
                    if not result.get('err_status', 1) and result.get('is_online', False):
                        normal += 1
                    else:
                        error += 1
            return str(normal) + ',' + str(error)
        except Exception as e:
            print(e)

    def insert_into_db(self):
        db = get_db()
        """
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':35,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':55,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':65,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':65,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':65,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
        db.ebc_status.save({'device_id':'0000','type':2,'value':65,'content':"当前环温",'create_date':datetime.utcnow()})
        time.sleep(2)
         """
        # time.sleep(2)
        # db.ebc_device.update({'_id': '10111111111111'},{'$set': {'alias':101}},False,True)
        temp4 = db.ebc_status.find({'device_id': '0000', 'type': 3}).sort([('create_date', -1)]).limit(24)

        # db.ebc_device.remove({'type':0})

        for i in temp4:
            print(i)

    def get_device_by_room(self, user_id, room_id, room_skip, room_limit, status=0):
        """
        根据roon_id分页查找设备
        :param room_id:
        :param room_skip:
        :param room_limit:
        :param status:
        :return:
        """
        db = get_db()
        devices = []
        my_skip = 0
        # 查找正常设备
        if status == 0:
            if room_id == '0':
                results = db.ebc_user_device.find({'user_id': user_id}).skip(room_skip).limit(room_limit)
            else:
                results = db.ebc_user_device.find({'room_id': ObjectId(room_id)}).skip(room_skip).limit(room_limit)
            return results
        # 查找异常设备
        else:
            if room_id == '0':
                results = db.ebc_user_device.find({'user_id': user_id}).skip(room_skip).limit(room_limit)


                my_skip = int(results.count())+int(room_skip)

            else:
                results = db.ebc_user_device.find({'room_id': ObjectId(room_id)}).skip(room_skip).limit(room_limit)
            for result in results:
                _id = result.get('device_id', None)

                if _id:
                    device = db.ebc_device.find_one({'_id': _id, 'is_abandon' :False})
                    if device:
                        is_online = device.get('is_online', False)
                        err_status = device.get('err_status', 1)
                        if is_online:
                            if err_status != 0:
                                devices.append(result)
                        else:
                            devices.append(result)
            return devices,my_skip

    def get_hum_and_tempe_byId(self, device_id):
        """
        获取设备状态信息
        :param device_id:
        :return:
        """
        db = get_db()
        back_dict = dict()
        device = db.ebc_device.find_one({'_id': device_id})
        dev_product_model = "无设备编号"
        # 用dev_status的值来标志设备的状态：0-正常，1-异常，2-离线
        dev_status = 1
        if device:
            # 默认设备状态错误
            err_status = device.get('err_status', 1)
            is_online = device.get('is_online', False)
            # 如果设备离线，就直接为离线状态，不需要知道是否异常
            if not is_online:
                dev_status = 2
            elif err_status != 0:
                dev_status = 1
            else:
                dev_status = 0
            tag = device.get('tag', None)
            if tag:
                dev_product_model = tag.get('product_model', '无设备编号')
                current_status = tag.get('current_status', None)
                dev_data = dict()
                if current_status:
                    status_array = current_status.split('|')
                    dev_data['env_temp'] = status_array[0]
                    dev_data['humidity'] = status_array[2]
                    dev_data['temp'] = status_array[1]
                else:
                    dev_data['env_temp'] = 0
                    dev_data['humidity'] = 0
                    dev_data['temp'] = 0
                back_dict['dev_data'] = dev_data

        back_dict['dev_id'] = device_id
        back_dict['dev_product_model'] = dev_product_model
        back_dict['dev_status'] = dev_status
        return back_dict

    def get_device_data(self, dev_id):
        """
        根据设备编号获取设备数据
        :param dev_id:
        :return:
        """
        db = get_db()
        dev_data = dict()

        temp = db.ebc_status.find({'device_id': dev_id, 'type': 1}).sort([('create_date', -1)]).limit(1)
        if temp.count():
            for t in temp:
                temp = t.get('value', None)
                if temp:
                    dev_data['env_temp'] = temp.get('env_temperature', 0)
                    dev_data['humidity'] = temp.get('humidity', 0)
                    dev_data['temp'] = temp.get('temperature', 0)
                else:
                    dev_data['env_temp'] = 0
                    dev_data['humidity'] = 0
                    dev_data['temp'] = 0
        else:
            dev_data['env_temp'] = 0
            dev_data['humidity'] = 0
            dev_data['temp'] = 0
        return dev_data

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


